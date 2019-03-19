package com.example.demo.service.impl;


import java.util.List;
import java.util.Map;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
 * @author zhaoyue
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	/*@Autowired
	private JedisCluster jedisCluster;*/
	


	@Override
	@Cacheable(value = "UserInfoList")
	public List<User> findAllUser() {
		log.info("测试缓存，第二次查询不走方法,不会打印此文字!!!");
		List<User> list = userMapper.findAll();
		return list;
	}


	@Override
	public Map<String, Object> redisMap() {
		// TODO Auto-generated method stub
		return null;
	}


	//@Override
	//public Map<String, Object> redisMap() {
		//jedisCluster.set("user", "张三丰");
		//设置完毕，获取之
		//String value = jedisCluster.get("user");
		//Map<String, Object> maps = new HashMap<String, Object>();
		//maps.put("redis", value);
		//return maps;
	//}

}
