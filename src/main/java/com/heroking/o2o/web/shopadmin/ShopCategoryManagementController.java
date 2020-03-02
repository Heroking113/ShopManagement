package com.heroking.o2o.web.shopadmin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @Author heroking
* @Date 2019年11月23日 下午9:49:30
* 类说明 
*/
@Controller
@RequestMapping("/shopadmin")
public class ShopCategoryManagementController {
	
	@RequestMapping(value="/getshopcategoryinfo", method=RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getShopCategoryManagementInfo(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", true);
		modelMap.put("Msg","接口开发中，Dao层和Service层已搭好！");
		
		return modelMap;
	}
	
	@RequestMapping(value="/registershopcategory", method=RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> registerShopCategory(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", true);
		modelMap.put("Msg","接口开发中，Dao层和Service层已搭好！");
		
		return modelMap;
	}
}
