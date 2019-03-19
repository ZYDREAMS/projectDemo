package com.example.demo.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhaoyue
 * @date 2019/3/2 17:20
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Component
public class TestRedisson {

    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void set() {
        // 设置字符串
        RBucket<String> keyObj = redissonClient.getBucket("k1");
        keyObj.set("v1236");
    }
}
