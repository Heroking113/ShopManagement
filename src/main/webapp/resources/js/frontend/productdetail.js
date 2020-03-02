$(function() {
	var detailUrl = "/o2o/frontend/productdetailinfo";
	// 从地址栏里获取productId
	var productId = getQueryString('productId');
	var searchDivUrl = "/o2o/frontend/productdetailinfo?productId=" + productId;
	getSearchDivData();

	// 获取本店铺信息以及商品类别信息列表
	function getSearchDivData() {
		var url = searchDivUrl;
		$.getJSON(url, function(data) {
			if (data.success) {
				var product = data.productdetail;
				console.log(product);
				$('#product-name').html(product.productName);
				$('#product-img').attr('src', product.imgAddr);
				$('#update-time').html(
						new Date(product.createTime).Format("yyyy-MM-dd"));
				$('#price').html('￥' + product.normalPrice);
				if (product.point != undefined) {
					$('#points').html('购买可得' + product.point + '积分');
				}
				// 商品价格展示逻辑
				if (product.normalPrice != undefined
						&& product.promotionPrice != undefined) {
					// 如果现价和原价都不为空则展示原价
					$('#price').show();
					$('#normalPrice').html(product.normalPrice);
				}
			}
		})
	}

	// 初始化页面
	$.init();
})