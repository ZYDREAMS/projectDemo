package com.example.demo.service;

import java.util.List;
import java.util.Map;


import com.example.demo.domain.User;

public interface UserService {

	/**
	 *  查询所有的user信息
	 * @return  所有user信息
	 */
	 List<User> findAllUser();

	 Map<String, Object> redisMap();
}
