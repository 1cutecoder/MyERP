package com.cskaoyan.mapper;

import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.OrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectPageOrder(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    int deleteByIds(@Param("ids") String[] ids);

    List<Order> selectOrderLikeId(@Param("id") String id,@Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    Long selectTotalCountLikeId(@Param("id")String searchValue);

    List<Order> selectLikeCustomName(@Param("customName") String searchValue, @Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    Long selectCountLikeCustomName(@Param("customName")String searchValue);

    Long selectCountLikeProductName(@Param("productName")String searchValue);

    List<Order> selectLikeProductName(@Param("productName")String searchValue,  @Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    List<Order> selectAllOrder();
}