package cn.knowei.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: knowei
 * @Description:
 * @Date: Create in 9:20 2023-03-17
 */
@Configuration
public class ApplicationContextConfig
{
    @Bean
    @LoadBalanced
    //负载均衡
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}

