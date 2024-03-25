package love.lisi.easyapiclientsdk;

import love.lisi.easyapiclientsdk.client.EasyApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * EasyApi 客户端配置
 *
 */
@Configuration
@ConfigurationProperties("easyapi.client")
@Data
@ComponentScan
public class EasyApiClientConfig {

    private String accessKey;

    private String secretKey;

    @Bean
    public EasyApiClient easyApiClient() {
        return new EasyApiClient(accessKey, secretKey);
    }

}
