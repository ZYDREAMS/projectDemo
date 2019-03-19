package com.example.demo.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhaoyue
 * @date 2019/3/1 21:22
 * @description
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestRedis {

    @Autowired
    private RedisServiceImpl redisService;

    @Test
    public  void  testRedisSet(){
        boolean flag=redisService.set("zhaoyue","好孩子");
        log.info("{}",flag);
    }
}
