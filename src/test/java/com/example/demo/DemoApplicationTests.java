package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoApplicationTests {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserService userService;

    /**
     * 测试jdbcTemplate
     */
    @Test
    public void contextLoads() {
            log.info("连接到数据库：{}",jdbcTemplate);
    }

    @Test
    public  void testRedisCache(){
        List<User> users= userService.findAllUser();
        log.info("{}",users);
    }
}
