function Declare() {
	var changed = true;
	var unchanged = false;
	
	this.declareId;
	this.declareDataId;
	
	// 申报单中数据变动flag(变动为true,未变动为false)
	this.dataFlag = unchanged;
	
	// 修改数据变动flag状态
	this.changeDataFlag = function(dataFlag) {
		this.dataFlag = dataFlag;
	}
	
	// 数据被修改
	this.changeData = function() {
		this.changeDataFlag(changed);
	}
	
	// 重置数据修改状态
	this.initChangeData = function() {
		this.changeDataFlag(unchanged);
	}
	
	// 校验数据是否有变动(变动返回true,未变动返回false)
	this.checkDataChanged = function() {
		if (this.dataFlag) {
			if (confirm("数据变动,是否保存?")) {
				this.saveDeclareData();
				this.initChangeData();
				return changed;
			} else {
				return unchanged;
			}
		}
		return unchanged;
	}
	
	// 打开新建申报单窗口
	this.showAddWin = function() {
		alert('弹窗');
		if (!this.checkDataChanged()) {
			
		}
	}
	
	// 保存申报单数据
	this.saveDeclare = function() {
		$.ajax({
			url : '${pageContext.request.contextPath}/declare/add',
			type : 'POST',
			data : {
				
			},
			success : function(result) {
				if ("success" == result) {
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
	
	// 删除申报单数据(包含申报类型数据)
	this.deleteDeclare = function() {
		alert('删除');
		if (this.declareId && !this.checkDataChanged()) {
			$.ajax({
				url : '${pageContext.request.contextPath}/declare/delete',
				type : 'POST',
				data : {
					id : this.declareId
				},
				success : function(result) {
					if ("success" == result) {
						alert("删除成功!");
					} else {
						alert("删除失败!");
					}
				},
				error : function(xhr, status) {
					alert("系统错误!");
				}
			});
		}
	}
	
	// 修改申报单数据
	this.updateDeclare = function() {
		if (!this.checkDataChanged()) {
			$.ajax({
				url : '${pageContext.request.contextPath}/declare/update',
				type : 'POST',
				data : {
					
				},
				success : function(result) {
					if ("success" == result) {
						this.initChangeData();
						alert("修改成功!");
					} else {
						alert("修改失败!");
					}
				},
				error : function(xhr, status) {
					alert("系统错误!");
				}
			});
		}
	}
	
	// 获取申报单数据
	this.getDeclare = function() {
		$.ajax({
			url : 'getDeclareList',
			type : 'POST',
			dataType : 'json',
			success : function(result) {
				if (result) {
					for (var i = 0; i < result.length; i++) {
						$('#declareMenu').text('');
						var declareId = result[i].id;
						var declareName = result[i].sheetName;
						var type = result[i].drloe;
						var typeCls;
						if ('buy' == type) {
							typeCls = 'bgy';
						} else {
							typeCls = 'bgi';
						}
						$('#declareMenu').append('<li declareId="' + declareId + '"><div class="fl ' + typeCls + '">' + result[i].sheetName + '</div><div class="cl"></div></li>');
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
	this.getDeclareData = function(declareId, type) {
		if ((!this.declareId || this.declareId != declareId) && !this.checkDataChanged()) {
			this.declareId = declareId;
			$.ajax({
				url : '${pageContext.request.contextPath}/declare/getDeclareData',
				type : 'POST',
				data : {
					id : declareId,
					type : type
				},
				success : function(result) {
					if (result) {
						
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
}