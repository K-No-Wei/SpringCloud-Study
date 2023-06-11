package cn.knowei.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: knowei
 * @Description:
 * @Date: Create in 14:25 2023-03-18
 */
@RestController
public class PaymentController
{
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private Lock lock = new ReentrantLock();



    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id)
    {
        return "nacos registry, serverPort: "+ serverPort+"\t id"+id;
    }


    /**
     * 分布式锁
     * @return
     */
    @GetMapping(value = "redis/sale")
    public String sale() {
        String msg = "";
        String key = "knoRedisLock";
        String uuidValue = UUID.randomUUID() + ":" + Thread.currentThread().getId();

        while (!stringRedisTemplate.opsForValue().setIfAbsent(key, uuidValue, 30L, TimeUnit.SECONDS)) {
            try { TimeUnit.MILLISECONDS.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
        }

        try {
            String result = stringRedisTemplate.opsForValue().get("inventory001");
            Integer inventory = result == null ? 0 : Integer.parseInt(result);
            if (inventory > 0) {
                stringRedisTemplate.opsForValue().set("inventory001", String.valueOf(--inventory));
                msg = Thread.currentThread().getName() + "  卖出 剩余-" + inventory + "  port:" + serverPort;
            } else {
                msg = Thread.currentThread().getName() + "  以及卖完了";
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } finally {
            if (stringRedisTemplate.opsForValue().get(key).equals(uuidValue)) {
                stringRedisTemplate.delete(key);
            }
        }
//        System.out.println(msg);
        return msg;
    }
}
