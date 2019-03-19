package com.example.demo.extendedanalysis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author zhaoyue
 * @date 2019/2/26 21:59
 * @description   CommandLineRunner是在容器启动最后一步
 */
@Slf4j
@Component
public class MyCommandLineRunner implements CommandLineRunner {


    @Override
    public void run(String... args){
        log.info("应用已启动");
    }
}
