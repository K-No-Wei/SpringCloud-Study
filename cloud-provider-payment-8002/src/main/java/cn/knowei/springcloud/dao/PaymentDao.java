package cn.knowei.springcloud.dao;

import cn.knowei.springcloud.entites.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: knowei
 * @Description:
 * @Date: Create in 8:56 2023-03-17
 */
@Mapper  //import org.apache.ibatis.annotations.Mapper;
public interface PaymentDao
{
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
