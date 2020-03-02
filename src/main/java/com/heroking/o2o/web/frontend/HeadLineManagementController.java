package com.heroking.o2o.web.frontend;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @Author heroking
* @Date 2019年11月25日 上午10:51:22
* 类说明 
*/
@Controller
@RequestMapping("/frontend")
public class HeadLineManagementController {
	@RequestMapping(value = "/getheadline", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getHeadLineInfo(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", true);
		modelMap.put("Msg","接口开发中，Dao层和Service层已搭好！");
		
		return modelMap;
	}
	
	@RequestMapping(value = "/registerheadline", method = RequestMethod.POST)
	@ResponseBody
	private Map<String,Object> registerHeadLine(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", true);
		modelMap.put("Msg","接口开发中，Dao层和Service层已搭好！");
		
		return modelMap;
	}
}
