package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Enki
 * @ClassName NacosConfig
 * @Description: TODO
 * @Date 2024/8/17 15:45
 * @Version 1.0
 */
@Configuration
@Data
@ConfigurationProperties(prefix = "pattern")
public class NacosConfig {
    private String dateFormat;
    private String say;
    private String aa;
    private String name;
}
