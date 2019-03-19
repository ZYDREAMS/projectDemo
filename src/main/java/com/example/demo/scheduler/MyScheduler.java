package com.example.demo.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhaoyue
 * @date 2019/3/4 22:09
 * @description  测试定时任务，项目启动每10s运行一次
 */
//@Component
@Slf4j
public class MyScheduler {
    @Scheduled(cron="0/10 * * * * ?")
    public void show(){
       log.info("OtherScheduler：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
    }
}
