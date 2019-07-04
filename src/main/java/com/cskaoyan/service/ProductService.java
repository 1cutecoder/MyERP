package com.cskaoyan.service;

import com.cskaoyan.bean.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/18 11:32
 */
public interface ProductService {
    Product getProductById(String id);

    int updateByPrimaryKey(Product product);

    List<Product> selectAllProduct();

    List<Product> findPageProduct(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    long selectTotalCount();

    int deleteBatch(String[] ids);

    List<Product> selectLikeName(String productName, int page, int rows);

    long selectCountLikeName(String productName);

    List<Product> selectLikeType(String searchValue, int page, int rows);

    long selectCountLikeType(String searchValue);

    List<Product> selectLikeId(String searchValue, int page, int rows);

    long selectCountLikeId(String searchValue);

    int insert(Product product);
}
