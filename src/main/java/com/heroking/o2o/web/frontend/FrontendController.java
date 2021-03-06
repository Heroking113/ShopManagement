package com.heroking.o2o.web.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author heroking
 * @Date 2019年11月22日 下午9:41:08 类说明
 */
@Controller
@RequestMapping("/frontend")
public class FrontendController {

	/**
	 * 首页路由
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	private String index() {
		return "frontend/index";
	}

	/**
	 * 店铺详情页路由
	 * 
	 * @return
	 */
	@RequestMapping(value = "/shopdetail", method=RequestMethod.GET)
	private String showShopDetail() {
		return "frontend/shopdetail";
	}

	/**
	 * 商品列表页路由
	 * 
	 * @return
	 */
	@RequestMapping(value = "/shoplist", method = RequestMethod.GET)
	private String showShopList() {
		return "frontend/shoplist";
	}
	
	/**
	 * 商品详情页路由
	 * @return
	 */
	@RequestMapping(value = "/productdetail", method = RequestMethod.GET)
	private String getProductDetail() {
		return "frontend/productdetail";
	}
}
