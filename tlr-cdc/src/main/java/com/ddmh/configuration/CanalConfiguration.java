package com.ddmh.configuration;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.net.InetSocketAddress;

/**
 * 加载canal single client 配置
 *
 * @author fbin
 * @version 2019/5/1 0001 18:49
 */
@Configuration
@EnableConfigurationProperties(CanalSingleClientProperties.class)
@Slf4j
public class CanalConfiguration {

    @Autowired
    private CanalSingleClientProperties canalSingleClientProperties;

    @PostConstruct
    public void init(){
        log.info("server.ip", canalSingleClientProperties.getIp());
        log.info("server.port", canalSingleClientProperties.getPort());
        log.info("server.destination", canalSingleClientProperties.getDestination());
        log.info("server.username", canalSingleClientProperties.getUsername());
        log.info("server.password", canalSingleClientProperties.getPassword());
    }

    @Bean
    public CanalConnector getSingleCanalConnector(){
        CanalConnector canalConnector = CanalConnectors.newSingleConnector(
                new InetSocketAddress(canalSingleClientProperties.getIp(), canalSingleClientProperties.getPort()),
                canalSingleClientProperties.getDestination(), canalSingleClientProperties.getUsername(), canalSingleClientProperties.getPassword());
        if(canalConnector.checkValid()){
            canalConnector.connect();
        }
        return canalConnector;
    }

}
