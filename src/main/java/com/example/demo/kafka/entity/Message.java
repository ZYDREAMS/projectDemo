package com.example.demo.kafka.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zhaoyue
 * @date 2019/3/11 15:28
 * @description
 */
@Data
public class Message {
    private Long id;
    private String msg;
    private Date sendTime;
}
