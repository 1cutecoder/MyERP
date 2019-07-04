package com.cskaoyan.controller;

import com.cskaoyan.bean.Product;
import com.cskaoyan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cute coder
 * 2019/5/18 11:31
 */
@Controller
@RequestMapping("/erp/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/find")
    public String find(){
        return "product_list";
    }

    @RequestMapping("/add")
    public String add() {
        return "product_add";
    }

    @RequestMapping("/edit")
    public String edit() {
        return "product_edit";
    }
    @RequestMapping("/get/{id}")
    @ResponseBody
    public Product getProduct(@PathVariable("id")String id){
        Product productById = productService.getProductById(id);
        return productById;
    }
    @RequestMapping("/edit_judge")
    @ResponseBody
    public Map editJudge(Product product) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }
    @RequestMapping("/add_judge")
    @ResponseBody
    public Map addJudge(Product product) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }
    @RequestMapping("/delete_judge")
    @ResponseBody
    public Map deleteJudge(Product product) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }


    @RequestMapping("/get_data")
    @ResponseBody
    public List<Product> getData() {
        List<Product> list=productService.selectAllProduct();
        return list;
    }

    @RequestMapping("insert")
    @ResponseBody
    public Map insert(Product product){
        HashMap<String, Object> map = new HashMap<>();
        boolean dataCorrected = confirm(map, product);
        if (!dataCorrected) {
            return map;
        }
        int insert = productService.insert(product);
        if (insert!=1) {
            map.put("status", 100);
            map.put("msg", "添加失败");
            map.put("data", null);
            return map;
        }
        map.put("status", 200);
        map.put("msg", "OK");
        map.put("data", null);
        return map;
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map deleteBatch(String[] ids) {
        HashMap<String, Object> map = new HashMap<>();
        int delete = productService.deleteBatch(ids);
        if (delete!= ids.length) {
            map.put("status", 100);
            map.put("msg", "删除失败");
            map.put("data", null);
            return null;
        }
        map.put("status", 200);
        map.put("msg", "OK");
        map.put("data", null);
        return map;
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public Map updataAll(Product product) {
        HashMap<String, Object> map = new HashMap<>();
        boolean dataCorrected = confirm(map, product);
        if (!dataCorrected) {
            return map;
        }
        int update=productService.updateByPrimaryKey(product);
        if (update!=1) {
            map.put("status", 100);
            map.put("msg", "修改失败");
            map.put("data", null);
        } else {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }
    @RequestMapping("list")
    @ResponseBody
    public Map findpage(int page, int rows) {
        List<Product> pageProduct = productService.findPageProduct(page, rows);
        long total = productService.selectTotalCount();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", pageProduct);
        return map;
    }

    @RequestMapping("search_product_by_productName")
    @ResponseBody
    public Map searchByName(String searchValue,int page, int rows) {
        List<Product> pageProduct = productService.selectLikeName(searchValue,page, rows);
        long total = productService.selectCountLikeName(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", pageProduct);
        return map;
    }

    @RequestMapping("search_product_by_productType")
    @ResponseBody
    public Map searchByType(String searchValue,int page, int rows) {
        List<Product> pageProduct = productService.selectLikeType(searchValue,page, rows);
        long total = productService.selectCountLikeType(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", pageProduct);
        return map;
    }
    @RequestMapping("search_product_by_productId")
    @ResponseBody
    public Map searchById(String searchValue,int page, int rows) {
        List<Product> pageProduct = productService.selectLikeId(searchValue,page, rows);
        long total = productService.selectCountLikeId(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", pageProduct);
        return map;
    }
    private boolean confirm(HashMap<String, Object> map, Product product) {

        if (product.getProductName().length() > 30) {
            map.put("status", 100);
            map.put("msg", "产品名称请限制在30个字符内");
            map.put("data", null);
            return false;
        }
        return true;
    }
}
