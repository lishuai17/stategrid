function LimitLine() {
	var myLimitLine = this;
	
	var changed = true;
	var unchanged = false;
	
	this.mcorhr;
	this.mdate;
	this.dtype;
	
	this.selectedDalare;
	this.limitLineType;	
	
	// 申报单中数据变动flag(变动为true,未变动为false)
	this.dataFlag = unchanged;
	
	// 修改数据变动flag状态
	this.changeDataFlag = function(dataFlag) {
		myLimitLine.dataFlag = dataFlag;
	}
	
	// 数据被修改
	this.changeData = function() {
		myLimitLine.changeDataFlag(changed);
	}
	
	// 重置数据修改状态
	this.initChangeData = function() {
		myLimitLine.changeDataFlag(unchanged);
	}
	
	// 校验数据是否有变动(变动返回true,未变动返回false)
	this.checkDataChanged = function() {
		if (myLimitLine.dataFlag) {
			if (confirm("数据变动,是否保存?")) {
				myLimitLine.updateLimitLine();
				myLimitLine.initChangeData();
				return changed;
			} else {
				myLimitLine.initChangeData();
				return unchanged;
			}
		}
		return unchanged;
	}
	
	// 显示申报单类型DIV
	this.showLimitLineDataDiv = function() {
		$('#limitLineDataDiv').show();
	}
	
	// 隐藏申报单类型DIV
	this.hideLimitLineDataDiv = function() {
		$('#limitLineDataDiv').hide();
	}
	
	// 修改申报单数据
	this.updateLimitLine = function() {
		$.ajax({
			url : 'updateLineLimit',
			type : 'POST',
			dataType : 'json',
			data : {
				limitLinePo : myLimitLine.makeLimitLineData(),
			},
			success : function(result) {
				if (result) {
					myLimitLine.initChangeData();
					myLimitLine.refreshLimitLineData();
					alert("保存成功!");
				} else {
					alert("保存失败!");
				}
			},
			error : function(xhr, status) {
				alert("系统错误!");
			}
		});
	}
	
	// 获取申报单数据
	this.getLimitLine = function() {
		$.ajax({
			url : 'getAllLine',
			type : 'POST',
			dataType : 'json',
			success : function(result) {
				if (result) {
					$('#limitLineMenu').text('');
					for (var i = 0; i < result.length; i++) {
						var limitLineId = result[i].mcorhr;
						
						$('#limitLineMenu').append('<li limitLineId="' + limitLineId + '" >'
								+ limitLineId
								+ '<div class="cl"></div></li>');
						myLimitLine.hideLimitLineDataDiv();
					}
					$('.count').text(result.length + '条');
				} else {
					alert("获取失败!");
				}
			},
			error : function(xhr, status) {
				alert("系统错误!");
			}
		});
	}
	
	// 获取申报单类型数据
	this.getLimitLineData = function(selectedDalare, type) {
		if ((!myLimitLine.selectedDalare || myLimitLine.selectedDalare.attr('limitLineId') != selectedDalare.attr('limitLineId')) && !myLimitLine.checkDataChanged()) {
			
			if (myLimitLine.selectedDalare) {
				myLimitLine.selectedDalare.attr('class', '');
				myLimitLine.selectedDalare.find('input').attr('class', '');
				myLimitLine.selectedDalare.find('input').attr('readonly', 'readonly');
			}
			selectedDalare.attr('class', 'bghh');
			selectedDalare.find('input').attr('class', 'bghh');
			
			myLimitLine.changeLimitLineTypeStyle(type);
			myLimitLine.selectedDalare = selectedDalare;
			myLimitLine.limitLineType = type;
			$.ajax({
				url : 'getLineLimit',
				type : 'POST',
				dataType : 'json',
				data : {
					mcorhr : selectedDalare.attr('limitLineId'),
					dtype : type
				},
				success : function(result) {
					if (result) {
						myLimitLine.mcorhr=result.mcorhr;
						myLimitLine.mdate=result.mdate;
						myLimitLine.dtype=result.dtype;
						myLimitLine.inputValueToTable(result);
						myLimitLine.makeDataToChart(result);
						myLimitLine.showLimitLineDataDiv();
					} else {
						alert("获取失败!");
					}
				},
				error : function(xhr, status) {
					alert("系统错误!");
				}
			});
		}
	}
	
	// 刷新申报单类型数据
	this.refreshLimitLineData = function() {
		
		$.ajax({
			url : 'getLineLimit',
			type : 'POST',
			dataType : 'json',
			data : {
				mcorhr : myLimitLine.selectedDalare.attr('limitLineId'),
				dtype : myLimitLine.limitLineType
			},
			success : function(result) {
				if (result) {
					myLimitLine.mcorhr=result.mcorhr;
					myLimitLine.mdate=result.mdate;
					myLimitLine.dtype=result.dtype;
					myLimitLine.inputValueToTable(result);
					myLimitLine.makeDataToChart(result);
					
					myLimitLine.showLimitLineDataDiv();
				} else {
					alert("获取失败!");
				}
			},
			error : function(xhr, status) {
				alert("系统错误!");
			}
		});
	}
	
	// 根据申报单类型获取申报单类型数据
	this.getLimitLineDataByLimitLineType = function(type) {
		if (!myLimitLine.checkDataChanged()) {
			myLimitLine.changeLimitLineTypeStyle(type);
			myLimitLine.limitLineType = type;
			limitLineType = type;
			$.ajax({
				url : 'getLineLimit',
				type : 'POST',
				dataType : 'json',
				data : {
					mcorhr : myLimitLine.selectedDalare.attr('limitLineId'),
					dtype : type
				},
				success : function(result) {
					if (result) {
						myLimitLine.mcorhr=result.mcorhr;
						myLimitLine.mdate=result.mdate;
						myLimitLine.dtype=result.dtype;
						myLimitLine.inputValueToTable(result);
						myLimitLine.makeDataToChart(result);
					} else {
						alert("获取失败!");
					}
				},
				error : function(xhr, status) {
					alert("系统错误!");
				}
			});
		}
	}
	
	// 将申报单类型数据插入表格中
	this.inputValueToTable = function(data) {
		if (data) {
			for (var key in data) {
				if (/^h[0-9]{2}$/.test(key)) {
					$('#limitLineDataDiv input[name=' + key + ']').val(data[key]);
				}
			}
			if (!data.sumQ || data.sumQ == 'null') {
				data.sumQ = 0;
			}
			if (!data.aveP || data.aveP == 'null') {
				data.aveP = 0;
			}
			$('#limitLineDataDiv span[name=sumValue]').text(data.sumQ);
			$('#limitLineDataDiv span[name=avgValue]').text(data.aveP);
		}
	}
	
	// 将申报单类型数据插入曲线图中
	this.makeDataToChart = function(data) {
		if (data) {
			var charts = {
					title : {
						text : '',
						x : -50 //center
					},
					xAxis : {
						categories : [
				              '00:00','00:15','00:30','00:45','01:00','01:15','01:30','01:45',
				              '02:00','02:15','02:30','02:45','03:00','03:15','03:30','03:45',
				              '04:00','04:15','04:30','04:45','05:00','05:15','05:30','05:45',
				              '06:00','06:15','06:30','06:45','07:00','07:15','07:30','07:45',
				              '08:00','08:15','08:30','08:45','09:00','09:15','09:30','09:45',
				              '10:00','10:15','10:30','10:45','11:00','11:15','11:30','11:45',
				              '12:00','12:15','12:30','12:45','13:00','13:15','13:30','13:45',
				              '14:00','14:15','14:30','14:45','15:00','15:15','15:30','15:45',
				              '16:00','16:15','16:30','16:45','17:00','17:15','17:30','17:45',
				              '18:00','18:15','18:30','18:45','19:00','19:15','19:30','19:45',
				              '20:00','20:15','20:30','20:45','21:00','21:15','21:30','21:45',
				              '22:00','22:15','22:30','22:45','23:00','23:15','23:30','23:45'
						] 
					},
					yAxis : {
						title : {
							text : '单位：MW'
						},
						plotLines : [{
							value : 0,
							width : 1,
							color : '#ffef00'
						}]
					},
					tooltip : {
						valueSuffix : 'MW'
					},
					legend : {
						layout : 'vertical',
						align : 'right',
						verticalAlign : 'middle',
						borderWidth : 0
					},
					series : [{
						name : '电力',
						data : [
					        data.h01, data.h02, data.h03, data.h04, data.h05, data.h06, data.h07, data.h08,
					        data.h09, data.h10, data.h11, data.h12, data.h13, data.h14, data.h15, data.h16,
					        data.h17, data.h18, data.h19, data.h20, data.h21, data.h22, data.h23, data.h24,
					        data.h25, data.h26, data.h27, data.h28, data.h29, data.h30, data.h31, data.h32,
					        data.h33, data.h34, data.h35, data.h36, data.h37, data.h38, data.h39, data.h40,
					        data.h41, data.h42, data.h43, data.h44, data.h45, data.h46, data.h47, data.h48,
					        data.h49, data.h50, data.h51, data.h52, data.h53, data.h54, data.h55, data.h56,
					        data.h57, data.h58, data.h59, data.h60, data.h61, data.h62, data.h63, data.h64,
					        data.h65, data.h66, data.h67, data.h68, data.h69, data.h70, data.h71, data.h72,
					        data.h73, data.h74, data.h75, data.h76, data.h77, data.h78, data.h79, data.h80,
					        data.h81, data.h82, data.h83, data.h84, data.h85, data.h86, data.h87, data.h88,
					        data.h89, data.h90, data.h91, data.h92, data.h93, data.h94, data.h95, data.h96
						]
					}]
				};
			$('.cchart').highcharts(charts);	
		}
	}
	
	// 整理需要修改的申报单数据
	this.makeLimitLineData = function() {
		var limitLine = {};
		var limitLineId = myLimitLine.selectedDalare.attr('limitLineId');
		
		var limitLineType = myLimitLine.limitLineType;
		var limitLineTypeData = myLimitLine.makeDataByTable();
		limitLine['mcorhr'] = limitLineId;
		limitLine['mdate'] = myLimitLine.mdate;
		alert( myLimitLine.dtype);

		limitLine['dtype'] = myLimitLine.dtype;
		limitLine['limitLineDatas'] = [limitLineTypeData];
		return JSON.stringify(limitLine);
	}
	
	// 根据表格整理申报单类型数据
	this.makeDataByTable = function() {
		var limitLineTypeDataInputs = $('#limitLineDataDiv').find('table input');
		var limitLineTypeData = {};
		var sum = 0;
		for (var index in limitLineTypeDataInputs) {
			var limitLineTypeDataInput = limitLineTypeDataInputs[index];
			limitLineTypeData[limitLineTypeDataInput.name] = limitLineTypeDataInput.value;
			if (limitLineTypeDataInput.value) {
				sum += Number(limitLineTypeDataInput.value);
			}
		}
		var avg = sum / 96;
		limitLineTypeData['id'] = myLimitLine.selectedDalare.attr('limitLineId');
		limitLineTypeData['dtype'] = myLimitLine.limitLineType;
		limitLineTypeData['sumQ'] = sum;
		limitLineTypeData['aveP'] = avg.toFixed(2);
		return limitLineTypeData;
	}
	
	// 申报单类型数据修改后按回车修改所有单元格数据
	this.copyTableValue = function(thisInput, e) {
		// 兼容FF和IE和Opera
		var theEvent = e || window.event;
		var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
		if (thisInput.focus() && code == 13) {
			var value = thisInput.val();
			for (var i = 1; i <= 96 ; i++) {
				var key;
				if (i < 10) {
					key = 'h0' + i;
				} else {
					key = 'h' + i;
				}
				$('#limitLineDataDiv input[name=' + key + ']').val(value);
			}
		}
	}
	
	// 修改申报单类型样式
	this.changeLimitLineTypeStyle = function(type) {
		var limitLineTypes = $('#limitLineDataDiv .conrightt1 a');
		for (var i = 0; i < 3 ; i++) {
			var limitLineType = limitLineTypes[i];
			if (limitLineType.name == type) {
				limitLineType.style.color = '#D1B664';
				limitLineType.style.fontWeight = 'bold';
			} else {
				limitLineType.style.color = '#7F7F7F';
				limitLineType.style.fontWeight = '';
			}
		}
	}
	
	// 修改申报单名称
	this.changeLimitLineName = function() {
		myLimitLine.selectedDalare.find('input').attr('class', '');
		myLimitLine.selectedDalare.find('input').attr('readonly', false);
		limitLine.changeData();
	}
	
	// 完成修改申报单名称
	this.finishChangeLimitLineName = function() {
		myLimitLine.selectedDalare.find('input').attr('class', 'bghh');
		myLimitLine.selectedDalare.find('input').attr('readonly', true);
	}
}