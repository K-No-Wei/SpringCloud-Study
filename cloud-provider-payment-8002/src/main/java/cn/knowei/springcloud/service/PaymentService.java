package cn.knowei.springcloud.service;

import cn.knowei.springcloud.entites.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: knowei
 * @Description:
 * @Date: Create in 9:01 2023-03-17
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);


}
