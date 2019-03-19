package com.example.demo;

import com.example.demo.extendedanalysis.MyApplicationContextInitializer;
import com.example.demo.event.MyApplicationEvent;
import com.example.demo.kafka.kafkaService.KafkaSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhaoyue
 * @description   @EnableCaching注解开启缓存
 */
@SpringBootApplication
@EnableCaching
@EnableScheduling
@EnableSwagger2
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {

      /*  SpringApplication.run(DemoApplication.class, args);*/
        SpringApplication application=new SpringApplication(DemoApplication.class);
      /*  //添加事件监听器，可以使用@Compont将类纳入spring管理
        application.addListeners(new MyApplicationListener());*/
        //添加分析扩展
        application.addInitializers(new MyApplicationContextInitializer());
        ConfigurableApplicationContext context=application.run(args);
        //发布事件
        context.publishEvent(new MyApplicationEvent(new Object()));
        //context.close();

        log.info("准备使用kafka");
        KafkaSender kafkaSender=context.getBean(KafkaSender.class);
        for(int i=0;i<5;i++){
            //调用消息发送类发送消息
            kafkaSender.send();
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                log.info("kafka消息发送中断");
            }
        }
    }

}
