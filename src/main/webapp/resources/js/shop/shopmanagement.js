$(function() {
	var shopId = getQueryString("shopId");
	console.log(shopId);
	var shopInfoUrl = "/o2o/shopadmin/getshopmanagementinfo?shopId=" + shopId;
	$.getJSON(shopInfoUrl, function(data) {
		console.log(data)
		if (data.redirect) {
			window.location.href = data.url;
		} else {
			if (data.shopId != undefined && data.shopId != null) {
				shopId = data.shopId;
			}
			$('#shopInfo').attr("href",
					"/o2o/shopadmin/shopoperation?shopId=" + shopId);
			$('#productManage').attr("href",
					"/o2o/shopadmin/productmanagement?shopId=" + shopId);
			$('#productCategory').attr("href",
					"/o2o/shopadmin/productcategorymanagement?shopId=" + shopId);
		}
	});
});