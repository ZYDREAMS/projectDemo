package com.example.demo.tomcat;

import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zhaoyue
 * @date 2019/3/3 11:03
 * @description 性能调优，实现WebServerFactoryCustomizer接口自定义对tomcat调优
 * Spring Boot2.0以上版本EmbeddedServletContainerCustomizer被WebServerFactoryCustomizer替代
 */
@Component
public class MyEmbeddedServletContainerCustomizer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {

        TomcatServletWebServerFactory tomcatServletWebServerFactory = (TomcatServletWebServerFactory) factory;
        //定制连接器
        tomcatServletWebServerFactory.addConnectorCustomizers((connector) -> {
            //tomcat有三种运行模式，这里使用Http11NioProtocol：http-bio:传统的阻塞io，性能比较低
            //http-nio：是一个基于缓冲区、并能提供非阻塞I/O操作。拥有比传统I/O操作(bio)更好的并发运行性能，默认的运行模式
            //http-apr：apr是Apache Http服务器的支持库。
            // 可以简单地理解为，Tomcat将以JNI的形式调用Apache HTTP服务器的核心动态链接库来处理文件读取或网络传输操作，
            // 从而大大地提高Tomcat对静态文件的处理性能。 Tomcat apr也是在Tomcat上运行高并发应用的首选模式
            Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
            //在这里定义端口口会优先使用，不会再使用配置文件中端口号,比自定义注入bean的优先级也高
            protocol.setPort(8079);
            protocol.setMaxConnections(200);
            protocol.setMaxThreads(200);
            protocol.setSelectorTimeout(3000);
            protocol.setSessionTimeout(3000);
            protocol.setConnectionTimeout(3000);
        });

    }
}
