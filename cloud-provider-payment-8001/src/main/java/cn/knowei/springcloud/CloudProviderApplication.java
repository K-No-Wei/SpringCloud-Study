package cn.knowei.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: knowei
 * @Description:
 * @Date: Create in 23:46 2023-03-16
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderApplication.class);
    }
}
