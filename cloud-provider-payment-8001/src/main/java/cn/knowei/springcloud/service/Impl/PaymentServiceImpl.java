package cn.knowei.springcloud.service.Impl;

import cn.knowei.springcloud.dao.PaymentDao;
import cn.knowei.springcloud.entites.Payment;
import cn.knowei.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: knowei
 * @Description:
 * @Date: Create in 9:02 2023-03-17
 */
@Service
public class PaymentServiceImpl implements PaymentService{
    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment)
    {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id)
    {
        return paymentDao.getPaymentById(id);
    }
}
