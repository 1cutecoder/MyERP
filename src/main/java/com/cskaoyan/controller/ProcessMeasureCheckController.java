package com.cskaoyan.controller;

import com.cskaoyan.bean.CodeType;
import com.cskaoyan.bean.ProcessMeasureCheck;
import com.cskaoyan.bean.ResponseVo;
import com.cskaoyan.service.ProcessMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/erp/p_measure_check")
public class ProcessMeasureCheckController {
    @Autowired
    ProcessMeasureCheckService processMeasureCheckService;
    @RequestMapping("find")
    @ResponseBody
    public ModelAndView find(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("p_measure_check_list");
        return modelAndView;
    }
    @RequestMapping("list")
    @ResponseBody
    public ResponseVo list(int page,int rows){
        List<ProcessMeasureCheck> allProcessMeasure = processMeasureCheckService.findAllProcessMeasure(page, rows);
        int total = (int)processMeasureCheckService.selectTotal();
        ResponseVo responseVo = new ResponseVo();
        responseVo.setRows(allProcessMeasure);
        responseVo.setTotal(total);
        return  responseVo;
    }
    //新增
    @RequestMapping("add")
    @ResponseBody
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("p_measure_check_add");
        return modelAndView;
    }
    @RequestMapping("insert")
    @ResponseBody
    public CodeType add(ProcessMeasureCheck processMeasureCheck){
        int i = processMeasureCheckService.addProcessMeasure(processMeasureCheck);
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
    @RequestMapping("edit")
    @ResponseBody
    public ModelAndView edit(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("p_measure_check_add");
        return modelAndView;
    }
    @RequestMapping("update_all")
    @ResponseBody
    public CodeType update(ProcessMeasureCheck processMeasureCheck){
        int i = processMeasureCheckService.updateProcessMeasure(processMeasureCheck);
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
    @RequestMapping("delete_batch")
    @ResponseBody
    public CodeType delete(String[] ids){
        int i = processMeasureCheckService.deleteProcessMeasure(ids);
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
    @RequestMapping("search_pMeasureCheck_by_pMeasureCheckId")
    @ResponseBody
    public ResponseVo searchProcessById(String searchValue,int page,int rows){
        List<ProcessMeasureCheck> processMeasureChecks = processMeasureCheckService.searchProcessById(searchValue, page, rows);
        ResponseVo responseVo = new ResponseVo();
        responseVo.setRows(processMeasureChecks);
        responseVo.setTotal(processMeasureChecks == null ? 0 : processMeasureChecks.size());
        return  responseVo;
    }
}
