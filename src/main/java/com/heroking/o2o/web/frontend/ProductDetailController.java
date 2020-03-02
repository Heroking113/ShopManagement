package com.heroking.o2o.web.frontend;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heroking.o2o.entity.Product;
import com.heroking.o2o.service.ProductService;
import com.heroking.o2o.util.HttpServletRequestUtil;

/**
 * @Author heroking
 * @Date 2019年12月17日 下午9:40:47 类说明
 */
@Controller
@RequestMapping("/frontend")
public class ProductDetailController {
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/productdetailinfo", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> productdetailinfo(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Long productId = HttpServletRequestUtil.getLong(request, "productId");
		Product product = new Product();
		product = productService.getProductById(productId);

		if (product != null) {
			modelMap.put("success", true);
			modelMap.put("productdetail", product);
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "empty product");
		}

		return modelMap;
	}

}
