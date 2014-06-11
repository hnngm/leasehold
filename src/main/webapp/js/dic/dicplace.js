//获得区县
function dicCountySelect(countyObj,firstSelectText,countyId) {
	$.getJSON("place/county/list", {
		cityId : '371600000000'
	}, function(data) {
		var option = '<option value="">请选择</option>';
		if(firstSelectText!=undefined){
			option = '<option value="">'+firstSelectText+'</option>';
		}
		$.each(data, function(i) {
			option += '<option value="' + this.id + '">' + this.name
					+ '</option>';
		});
		$(countyObj).html(option);
		if(countyId!=undefined){
			$(countyObj).val(countyId);
		}
	});
}
//获得区县
function dicCounty(countyObj,townObj,firstSelectText,countyId, townId) {
	$.getJSON("place/county/list", {
		cityId : '371600000000'
	}, function(data) {
		var option = '<option value="">请选择</option>';
		if(firstSelectText!=undefined){
			option = '<option value="">'+firstSelectText+'</option>';
		}
		$.each(data, function(i) {
			option += '<option value="' + this.id + '">' + this.name
					+ '</option>';
		});
		$(countyObj).html(option);
		if(countyId!=undefined){
			$(countyObj).val(countyId);
		}
		if(townId!=undefined){
			dicTown(townObj,countyId,townId,firstSelectText);
		}
			$(countyObj).on("change", function(event) {
					dicTown(townObj, $(this).val(),'',firstSelectText);
			});
	});
		dicTown(townObj, '', '',firstSelectText);
}
// 获得区县
function dicTown(townObj, countyId, townId,firstSelectText) {
	$(townObj).html('<option value="">请选择</option>');
	if(firstSelectText!=undefined){
		$(townObj).html('<option value="">'+firstSelectText+'</option>');
	}
	if (countyId == "") {
		return false;
	}
	$.getJSON("place/town/list", {
		countyId : countyId
	}, function(data) {
		var option = '';
		$.each(data, function() {
			option += '<option value="' + this.id +'">' + this.name
					+ '</option>';
		});
		$(townObj).append(option);
		if (townId != undefined) {
			$(townObj).val(townId);
		}
	});
}
