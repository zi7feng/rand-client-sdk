package com.fzq.tapiclientsdk;

import com.fzq.tapiclientsdk.client.TapiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("tapi.client")
@Data
@ComponentScan
public class TapiClientConfig {
    private String accessKey;
    private String secretKey;

    @Bean
    public TapiClient tapiClient() {
        return new TapiClient(accessKey, secretKey);
    }

}
