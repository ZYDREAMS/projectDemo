package com.example.demo.mapper;



import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author zhaoyue
 */
@Mapper
public interface UserMapper {

	/**
	 * 查询所有
	 * @return 返回所有
	 */
	List<User> findAll();

}
