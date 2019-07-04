package com.cskaoyan.controller;

import com.cskaoyan.bean.CodeType;
import com.cskaoyan.bean.ProcessCountCheck;
import com.cskaoyan.bean.ResponseVo;
import com.cskaoyan.service.ProcessCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/erp/p_count_check")
public class ProcessCountCheckController {
    @Autowired
    ProcessCountCheckService processCountCheckService;
    @RequestMapping("find")
    @ResponseBody
    public ModelAndView find(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("p_count_check_list");
        return modelAndView;
    }
    @RequestMapping("list")
    @ResponseBody
    public ResponseVo findList(int page,int rows){
        List<ProcessCountCheck> allProcessCount = processCountCheckService.findAllProcessCount(page, rows);
        int total =(int) processCountCheckService.selectTotal();
        ResponseVo responseVo = new ResponseVo();
        responseVo.setRows(allProcessCount);
        responseVo.setTotal(total);
        return responseVo;
    }

    //新增
    @RequestMapping("add")
    @ResponseBody
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("p_count_check_add");
        return modelAndView;
    }
    @RequestMapping("insert")
    @ResponseBody
    public CodeType insert(ProcessCountCheck processCountCheck){
        CodeType codeType = new CodeType();
        int i = processCountCheckService.insert(processCountCheck);
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
    // 编辑
    @RequestMapping("edit")
    @ResponseBody
    public ModelAndView edit(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("p_count_check_edit");
        return modelAndView;
    }
    @RequestMapping("update_all")
    @ResponseBody
    public CodeType update(ProcessCountCheck processCountCheck){
        CodeType codeType = new CodeType();
        int i = processCountCheckService.update(processCountCheck);
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
        CodeType codeType = new CodeType();
        int i = processCountCheckService.deleteProcessCount(ids);
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
    @RequestMapping("search_pCountCheck_by_pCountCheckId")
    @ResponseBody
    public ResponseVo searchpCountById( String searchValue, int page,int rows){
        List<ProcessCountCheck> processCountChecks = processCountCheckService.searchpCountById(searchValue, page, rows);
        ResponseVo responseVo = new ResponseVo();
        responseVo.setRows(processCountChecks);
        responseVo.setTotal(processCountChecks == null ? 0 : processCountChecks.size());
        return responseVo;
    }
}
