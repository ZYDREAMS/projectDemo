package com.example.demo.redis.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author zhaoyue
 * @date 2019/3/2 17:14
 * @description
 */
//@Configuration
public class RedissonConfig {
    @Bean
    public RedissonClient redisson() throws IOException {
        // 本例子使用的是yaml格式的配置文件，读取使用Config.fromYAML，如果是Json文件，则使用Config.fromJSON
        Config config = Config.fromYAML(RedissonConfig.class.getClassLoader().getResource("config/redisson-config.yaml"));
        config.setTransportMode(TransportMode.NIO);
        config.setCodec(JsonJacksonCodec.INSTANCE);

        return Redisson.create(config);
    }
}
