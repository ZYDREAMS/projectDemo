package com.example.demo.event;

import org.springframework.context.ApplicationEvent;


/**
 * @author zhaoyue
 * @date 2019/2/26 20:05
 * @description 定义事件
 */
public class MyApplicationEvent extends ApplicationEvent {

    public MyApplicationEvent(Object source) {
        super(source);
    }
}
