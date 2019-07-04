package com.cskaoyan.service;

import com.cskaoyan.bean.Order;

import java.util.List;


public interface Orderservice {
    List<Order> findPageOrder(int page, int rows);

    Long selectTotalCount();

    int updateByPrimaryKey(Order order);

    int deleteBatch(String[] ids);

    List<Order> selectOrderLikeId(String searchValue, int page, int rows);

    Long selectTotalCountLikeId(String searchValue);

    List<Order> selectOrderLikeCustomName(String searchValue, int page, int rows);

    Long selectCountLikeCustomName(String searchValue);

    Long selectCountLikeProductName(String searchValue);

    List<Order> selectOrderLikeProductName(String searchValue, int page, int rows);

    List<Order> selectAllOrder();

    int insert(Order order);
}
