package com.example.demo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


/**
 * @author zhaoyue
 * @date 2019/2/26 20:13
 * @description  定义事件监听器
 */
@Slf4j
@Component
public class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {

    @Override
    public void onApplicationEvent(MyApplicationEvent myApplicationEvent) {
        log.info("MyApplicationListener接收到事件：{}",myApplicationEvent.getClass());

    }
}
