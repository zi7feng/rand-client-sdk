package com.fzq.randclientsdk;

import com.fzq.randclientsdk.client.RandClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("rand-api.client")
@Data
@ComponentScan
public class RandClientConfig {
    private String accessKey;
    private String secretKey;

    @Bean
    public RandClient randClient() {
        return new RandClient(accessKey, secretKey);
    }

}
