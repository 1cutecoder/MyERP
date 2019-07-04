package com.cskaoyan.controller;

import com.cskaoyan.bean.CodeType;
import com.cskaoyan.bean.Employee;
import com.cskaoyan.bean.ResponseVo;
import com.cskaoyan.bean.UnqualifyApply;
import com.cskaoyan.service.QualifyService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/erp/unqualify")
public class QualityController {
    @Autowired
    QualifyService qualifyService;
    //查找显示
    @RequestMapping("find")
    @ResponseBody
    public ModelAndView unqualify(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("unqualify_list");
        return modelAndView;
    }
    @RequestMapping("list")
    @ResponseBody
    public ResponseVo findpage(int page,int rows){
        PageHelper.startPage(page,rows);
        ResponseVo<UnqualifyApply> responseVo = new ResponseVo<>();
        List<UnqualifyApply> unqualifyByPage = qualifyService.findUnqualifyByPage();
        int total = (int)qualifyService.selectTotal();
        responseVo.setRows(unqualifyByPage);
         responseVo.setTotal(total);
        return responseVo;
    }
    //增加数据
    @RequestMapping("add_judge")
    @ResponseBody
    public ModelAndView addJudge(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("unqualify_add");
        return modelAndView;
    }
    @RequestMapping("add")
    @ResponseBody
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("unqualify_add");
        return modelAndView;
    }
    @RequestMapping("insert")
    @ResponseBody
    public CodeType insert(UnqualifyApply unqualifyApply){
        int i = qualifyService.addUnqualify(unqualifyApply);
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
    //编辑数据
    @RequestMapping("edit_judge")
    @ResponseBody
    public ModelAndView editJudge(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("unqualify_edit");
        return modelAndView;
    }
    @RequestMapping("edit")
    @ResponseBody
    public ModelAndView edit(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("unqualify_edit");
        return modelAndView;
    }
    @RequestMapping("update_all")
    @ResponseBody
    public CodeType updateAll(UnqualifyApply unqualifyApply){
        int i = qualifyService.updateUnqualify(unqualifyApply);
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

    //删除数据

    @RequestMapping("delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "";
    }
    @RequestMapping("delete_batch")
    @ResponseBody
    public CodeType delete(String[] ids){
        int i = qualifyService.deleteUnqualifyApplyById(ids);
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
    // 条件查询
    @RequestMapping("search_unqualify_by_unqualifyId")
    @ResponseBody
    public ResponseVo search(String searchValue,int page,int rows){
        List<UnqualifyApply> unqualifyApplies = qualifyService.searchById(searchValue, page, rows);
        ResponseVo<UnqualifyApply> responseVo = new ResponseVo<>();
        responseVo.setRows(unqualifyApplies);
        responseVo.setTotal(unqualifyApplies == null ? 0 : unqualifyApplies.size());
        return responseVo;
    }
    @RequestMapping("search_unqualify_by_productName")
    @ResponseBody
    public ResponseVo searchByName(String searchValue,int page,int rows){
        List<UnqualifyApply> unqualifyApplies = qualifyService.searchByName(searchValue, page, rows);
        ResponseVo<UnqualifyApply> responseVo = new ResponseVo<>();
        responseVo.setRows(unqualifyApplies);
        responseVo.setTotal(unqualifyApplies == null ? 0 : unqualifyApplies.size());
        return responseVo;
    }
}
