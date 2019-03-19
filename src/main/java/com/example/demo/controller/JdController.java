package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author zhaoyue
 */
@Controller
@Api("Swagger2测试controller相关Api")
public class JdController {
	
	/**
	 * 需求：返回jd首页
	 */
	@RequestMapping("list")
	@ApiOperation(value = "进入首页",notes = "jd的首页")
	public String jdList(){
		return "index";
	}


	/**
	 *  测试模板引擎
	 * @param map
	 * @return  页面
	 */
	@RequestMapping("success")
	public String success(Map<String,Object> map){
		map.put("hello","你好");
		return "success";
	}

}
