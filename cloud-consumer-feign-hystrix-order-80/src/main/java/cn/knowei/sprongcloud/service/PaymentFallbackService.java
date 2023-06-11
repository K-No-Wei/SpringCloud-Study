package cn.knowei.sprongcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author: knowei
 * @Description:
 * @Date: Create in 21:47 2023-03-17
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "--------------paymentInfo_OK    fall back--------------";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "--------------paymentInfo_TimeOut   fall back--------------";
    }
}
