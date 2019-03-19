package com.example.demo.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhaoyue
 */
@Data
public class User implements Serializable{
	
	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = 1L;
	private int  id;
	private String name;
	private int age;

	
	


}
