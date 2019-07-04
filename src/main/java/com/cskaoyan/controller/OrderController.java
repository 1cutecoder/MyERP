package com.cskaoyan.controller;

import com.cskaoyan.bean.Order;
import com.cskaoyan.service.Orderservice;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by com cskaoyan
 * 2019/5/17 16:53
 */

@Controller
@RequestMapping("/erp/order")
public class OrderController {

    @Autowired
    Orderservice orderService;

    @RequestMapping("find")
    @ResponseBody
    public ModelAndView find() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order_list");
        return modelAndView;
    }

    @RequestMapping("/add")
    public String add() {
        return "order_add";
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public Map editJudge(Order order) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public Map addJudge(Order order) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public Map deleteJudge(Order order) {
        HashMap<String, Object> map = new HashMap<>();
        return null;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(Order order){
        HashMap<String, Object> map = new HashMap<>();
        int insert = orderService.insert(order);
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
        HashMap<Object, Object> map = new HashMap<>();
        int delete = orderService.deleteBatch(ids);
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
    @RequestMapping("/update_note")
    @ResponseBody
    public Map updateNote(Order order) {
        HashMap<String, Object> map = new HashMap<>();
        int update = orderService.updateByPrimaryKey(order);
        if (update != 1) {
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



    @RequestMapping("/search_order_by_orderId")
    @ResponseBody
    public Map searchOrderbyOrderId(String searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        long total =orderService.selectTotalCountLikeId(searchValue);
        List<Order> orders = orderService.selectOrderLikeId(searchValue,page,rows);
        map.put("total",total);
        map.put("rows",orders);
        return map;
    }

    @RequestMapping("search_order_by_orderProduct")
    @ResponseBody
    public Map searchByOrderProduct(String searchValue,int page, int rows) {
        List<Order> pageWork = orderService.selectOrderLikeProductName(searchValue,page, rows);
        long total = orderService.selectCountLikeProductName(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", pageWork);
        return map;
    }
    @RequestMapping("search_order_by_orderCustom")
    @ResponseBody
    public Map searchByOrderCustom(String searchValue,int page, int rows) {
        List<Order> pageWork = orderService.selectOrderLikeCustomName(searchValue,page, rows);
        long total = orderService.selectCountLikeCustomName(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", pageWork);
        return map;
    }

    @RequestMapping("list")
    @ResponseBody
    public Map findpage(int page, int rows) {
        List<Order> pageOrder = orderService.findPageOrder(page, rows);
        long total = orderService.selectTotalCount();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", pageOrder);
        return map;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Order> getData() {
        List<Order> list=orderService.selectAllOrder();
        return list;
    }


}
