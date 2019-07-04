package com.cskaoyan.mapper;

import com.cskaoyan.bean.Product;
import com.cskaoyan.bean.ProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(String productId);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectAllProduct();

    List<Product> findPageProduct(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    int deleteByIds(@Param("ids") String[] ids);

    List<Product> selectPageProductLike(Product product, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    List<Product> selectLikeCondition(@Param("product") Product product, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    Long selectCountLikeCondition(@Param("product") Product product);
}