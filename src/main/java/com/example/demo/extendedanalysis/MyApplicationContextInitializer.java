package com.example.demo.extendedanalysis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zhaoyue
 * @date 2019/2/26 21:08
 * @description   springboot扩展分析,在main方法中添加初始化配置
 *    ApplicationContextInitializer是spring 容器执行refreshed之前的一个回调
 */
@Slf4j
public class MyApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
          log.info("bean count:{}",configurableApplicationContext.getBeanDefinitionCount());
    }
}
