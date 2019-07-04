package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/erp/pMeasureCheck")
public class ProcessMeasureController {
    @RequestMapping("add_judge")
    @ResponseBody
    public ModelAndView addJudge(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("p_measure_check_add");
        return modelAndView;
    }
    @RequestMapping("edit_judge")
    @ResponseBody
    public String editJudge(){
        return "";
    }
    @RequestMapping("delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "";
    }
}
