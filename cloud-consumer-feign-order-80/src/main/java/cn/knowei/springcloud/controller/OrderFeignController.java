package cn.knowei.springcloud.controller;

import cn.knowei.springcloud.entites.CommonResult;
import cn.knowei.springcloud.entites.Payment;
import cn.knowei.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: knowei
 * @Description:
 * @Date: Create in 19:39 2023-03-17
 */
@RestController
public class OrderFeignController
{
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        return paymentFeignService.getPaymentById(id);
    }
}
