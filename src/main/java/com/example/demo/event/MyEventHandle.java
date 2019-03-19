package com.example.demo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author zhaoyue
 * @date 2019/2/26 20:42
 * @description
 */
@Slf4j
@Component
public class MyEventHandle {

    /**
     * 方法的参数一定要是ApplicationEvent或者是其子类
     * @param event
     */
    @EventListener
    public  void  event(MyApplicationEvent event){
      log.info("MyEventHandle接收到事件：{}",event.getClass());
    }
}
