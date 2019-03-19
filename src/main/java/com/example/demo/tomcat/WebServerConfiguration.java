package com.example.demo.tomcat;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

/**
 * @author zhaoyue
 * @date 2019/3/3 11:46
 * @description 通过configuration性能调优
 */
@SpringBootApplication
@Slf4j
public class WebServerConfiguration{

        @Bean
        public ConfigurableServletWebServerFactory webServerFactory() {
            TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
            factory.addConnectorCustomizers(connector -> {
                Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
                log.info("自定义配置tomcat启用");
                protocol.setDisableUploadTimeout(false);
                protocol.setPort(9998);
            });
            return factory;
        }

}
