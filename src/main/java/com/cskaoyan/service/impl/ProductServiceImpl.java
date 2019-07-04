package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Product;
import com.cskaoyan.bean.ProductExample;
import com.cskaoyan.mapper.ProductMapper;
import com.cskaoyan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/18 11:33
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public Product getProductById(String id) {
        Product product = productMapper.selectByPrimaryKey(id);
        return product;
    }

    @Override
    public int updateByPrimaryKey(Product product) {
        int update = productMapper.updateByPrimaryKey(product);
        return update;
    }

    @Override
    public List<Product> selectAllProduct() {
        List<Product> list=productMapper.selectAllProduct();
        return list;
    }

    @Override
    public List<Product> findPageProduct(int page, int rows) {
        int startIndex = (page - 1) * rows;
        List<Product> products = productMapper.findPageProduct(startIndex, rows);
        return products;
    }

    @Override
    public long selectTotalCount() {
        ProductExample productExample = new ProductExample();
        long count= productMapper.countByExample(productExample);
        return count;
    }

    @Override
    public int deleteBatch(String[] ids) {
        int  deletes=productMapper.deleteByIds(ids);
        return deletes;
    }

    @Override
    public List<Product> selectLikeName(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        Product product = new Product();
        product.setProductName(searchValue);
        List<Product> products = productMapper.selectLikeCondition(product, startIndex, pageSize);
        return products;
    }

    @Override
    public long selectCountLikeName(String searchValue) {
        Product product = new Product();
        product.setProductName(searchValue);
        Long count = productMapper.selectCountLikeCondition(product);
        return count;
    }

    @Override
    public List<Product> selectLikeType(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        Product product = new Product();
        product.setProductType(searchValue);
        List<Product> products = productMapper.selectLikeCondition(product, startIndex, pageSize);
        return products;
    }

    @Override
    public long selectCountLikeType(String searchValue) {
        Product product = new Product();
        product.setProductType(searchValue);
        Long count = productMapper.selectCountLikeCondition(product);
        return count;
    }

    @Override
    public List<Product> selectLikeId(String searchValue, int page, int rows) {
        int startIndex=(page-1)*rows;
        int pageSize=rows;
        Product product = new Product();
        product.setProductId(searchValue);
        List<Product> products = productMapper.selectLikeCondition(product, startIndex, pageSize);
        return products;
    }

    @Override
    public long selectCountLikeId(String searchValue) {
        Product product = new Product();
        product.setProductId(searchValue);
        Long count = productMapper.selectCountLikeCondition(product);
        return count;
    }

    @Override
    public int insert(Product product) {
        int insert = productMapper.insert(product);
        return insert;
    }
}
