package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Order;
import com.atguigu.cloud.mapper.OrderMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl {

    @Resource
    private OrderMapper orderMapper;
    public int addOrder(Double amount, String address) {
        int order = addOrder2(amount, address);
        return order;
    }

    @Transactional(rollbackFor = Exception.class)
    public int addOrder2(Double amount, String address) {
        Order orderEntiry = new Order();
        orderEntiry.setCount(amount.intValue());
        orderEntiry.setStatus(Integer.valueOf(address));
        int order = orderMapper.insert(orderEntiry);
        int i = order / 0;
        return order;
    }
}