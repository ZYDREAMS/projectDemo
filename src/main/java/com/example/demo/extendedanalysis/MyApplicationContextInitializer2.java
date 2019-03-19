package com.example.demo.extendedanalysis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zhaoyue
 * @date 2019/2/26 21:08
 * @description   springboot扩展分析,添加初始化配置，在默认配置文件中配置
 *    ApplicationContextInitializer是spring 容器执行refreshed之前的一个回调
 */
@Slf4j
public class MyApplicationContextInitializer2 implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
             for(String beanName:configurableApplicationContext.getBeanDefinitionNames()){
                 log.info("bean name is:{}",beanName);
             }
    }
}
