package com.cskaoyan.controller;

import com.cskaoyan.bean.CodeType;
import com.cskaoyan.bean.FinalCountCheck;
import com.cskaoyan.bean.ResponseVo;
import com.cskaoyan.service.FinalCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/erp/f_count_check")
public class FinalCountController {
    @Autowired
    FinalCountService finalCountService;
    @RequestMapping("find")
    public String find(){
        return "f_count_check_list";
    }
    @RequestMapping("list")
    @ResponseBody
    public ResponseVo findList(int page,int rows){
        ResponseVo responseVo = new ResponseVo();
        List<FinalCountCheck> allFinalCount = finalCountService.findAllFinalCount(page, rows);
        int total = (int)finalCountService.searchTotal();
        responseVo.setRows(allFinalCount);
        responseVo.setTotal(total);
        return responseVo;
    }
    //增加
    @RequestMapping("add")
    @ResponseBody
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("f_count_check_add");
        return modelAndView;
    }
    @RequestMapping("insert")
    @ResponseBody
    public CodeType insert(FinalCountCheck finalCountCheck){
        int i = finalCountService.addFinalCount(finalCountCheck);
        CodeType codeType = new CodeType();
        if(i != 0){
            codeType.setMsg("OK");
            codeType.setStatus("200");
            codeType.setData(null);
        }else {
            codeType.setMsg("NO");
            codeType.setStatus("500");
            codeType.setData("错误！");
        }
        return codeType;
    }
    //编辑
    @RequestMapping("edit")
    @ResponseBody
    public ModelAndView edit(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("f_count_check_edit");
        return modelAndView;
    }
    @RequestMapping("update_all")
    @ResponseBody
    public CodeType update(FinalCountCheck finalCountCheck){
        int i = finalCountService.updateFinalCount(finalCountCheck);
        CodeType codeType = new CodeType();
        if(i != 0){
            codeType.setMsg("OK");
            codeType.setStatus("200");
            codeType.setData(null);
        }else {
            codeType.setMsg("NO");
            codeType.setStatus("500");
            codeType.setData("错误！");
        }
        return codeType;
    }
    // 删除
    @RequestMapping("delete_batch")
    @ResponseBody
    public CodeType delete(String[] ids){
        int i = finalCountService.deleteFinalCount(ids);
        CodeType codeType = new CodeType();
        if(i != 0){
            codeType.setMsg("OK");
            codeType.setStatus("200");
            codeType.setData(null);
        }else {
            codeType.setMsg("NO");
            codeType.setStatus("500");
            codeType.setData("错误！");
        }
        return codeType;
    }
    @RequestMapping("search_fCountCheck_by_fCountCheckId")
    @ResponseBody
    public ResponseVo searchfCountById(String searchValue,int page,int rows){
        ResponseVo responseVo = new ResponseVo();
        List<FinalCountCheck> finalCountChecks = finalCountService.searchfCountById(searchValue, page, rows);
        responseVo.setRows(finalCountChecks);
        responseVo.setTotal(finalCountChecks == null ? 0 : finalCountChecks.size());
        return responseVo;
    }
    @RequestMapping("search_fCountCheck_by_orderId")
    @ResponseBody
    public ResponseVo searchfCountByOid(String searchValue,int page,int rows){
        ResponseVo responseVo = new ResponseVo();
        List<FinalCountCheck> finalCountChecks = finalCountService.searchfCountByOid(searchValue, page, rows);
        responseVo.setRows(finalCountChecks);
        responseVo.setTotal(finalCountChecks == null ? 0 : finalCountChecks.size());
        return responseVo;
    }
}
