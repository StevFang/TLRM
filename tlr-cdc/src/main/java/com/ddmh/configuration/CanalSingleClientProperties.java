package com.ddmh.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * canal 配置
 *
 * @author fbin
 * @version 2019/5/1 0001 18:36
 */
@PropertySource("classpath:config/canal-single-client.properties")
@ConfigurationProperties("canal.server")
@Configuration
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class CanalSingleClientProperties {

    private String ip;
    private Integer port;
    private String destination;
    private String username;
    private String password;

}
