package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.OrderExample;
import com.cskaoyan.mapper.OrderMapper;
import com.cskaoyan.service.Orderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderServiceImpl implements Orderservice {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> findPageOrder(int page, int rows) {
        int startIndex = (page - 1) * rows;
        List<Order> orders = orderMapper.selectPageOrder(startIndex, rows);
        return orders;
    }

    @Override
    public Long selectTotalCount() {
        OrderExample orderExample = new OrderExample();
        long orderCount= orderMapper.countByExample(orderExample);
        return orderCount;
    }

    @Override
    public int updateByPrimaryKey(Order order) {
        int update = orderMapper.updateByPrimaryKey(order);
        return update;
    }

    @Override
    public int deleteBatch(String[] ids) {
        int  deletes=orderMapper.deleteByIds(ids);
        return deletes;
    }

    @Override
    public List<Order> selectOrderLikeId(String searchValue,int page,int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<Order> orders = orderMapper.selectOrderLikeId(searchValue, startIndex, pageSize);
        return orders;
    }

    @Override
    public Long selectTotalCountLikeId(String searchValue) {
        Long count = orderMapper.selectTotalCountLikeId(searchValue);
        return count;
    }

    @Override
    public List<Order> selectOrderLikeCustomName(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<Order> orders =orderMapper.selectLikeCustomName(searchValue, startIndex, pageSize);
        return orders;
    }

    @Override
    public Long selectCountLikeCustomName(String searchValue) {
        Long count =orderMapper.selectCountLikeCustomName(searchValue);
        return count;
    }

    @Override
    public Long selectCountLikeProductName(String searchValue) {
        Long count =orderMapper.selectCountLikeProductName(searchValue);
        return count;
    }

    @Override
    public List<Order> selectOrderLikeProductName(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        List<Order> orders =orderMapper.selectLikeProductName(searchValue, startIndex, pageSize);
        return orders;    }

    @Override
    public List<Order> selectAllOrder() {
        List<Order> orders = orderMapper.selectAllOrder();
        return orders;
    }

    @Override
    public int insert(Order order) {
        int insert = orderMapper.insert(order);
        return insert;
    }

}
