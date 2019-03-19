package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zhaoyue
 */
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("info")
	public User hello(){
		
		User user = new User();
		
		user.setName("张三丰");

		return user;
	}

	@RequestMapping("list1")
	public List<User> list(){
		List<User> list = userService.findAllUser();
		return list;
	}
	
	/**
	 * 需求：操作REDIS集群缓存
	 */
	@RequestMapping("redis")
	public String redisMap(Model model){
		//Map<String, Object> maps = userService.redisMap();
		model.addAttribute("hello", "张三丰");
		return null;
	}
}
