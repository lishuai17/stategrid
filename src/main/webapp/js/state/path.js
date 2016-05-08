function areaSelect(url,selectNodes){
	
	$.ajax({
		url : url,
		type : 'POST',
		dataType:'json',
		success : function(result) {
			if (result) {
				for (var j = 0; j < selectNodes.length; j++) {
					var selectNode = selectNodes[j];
					selectNode.html("");
					for (var i = 0; i < result.length; i++) {
						var name = result[i].area;
						var option = '<option value="'+name+'">'+name+'</option>';
						selectNode.append(option);
					}
				}
			} 
		},
		error : function(xhr, status) {
			alert("系统错误!");
		}
	});
	
}