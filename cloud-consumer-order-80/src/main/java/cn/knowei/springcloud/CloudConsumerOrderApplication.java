package cn.knowei.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: knowei
 * @Description:
 * @Date: Create in 9:19 2023-03-17
 */
@SpringBootApplication
@EnableEurekaClient
// @RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration= MySelfRule.class)
public class CloudConsumerOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrderApplication.class);
    }
}
