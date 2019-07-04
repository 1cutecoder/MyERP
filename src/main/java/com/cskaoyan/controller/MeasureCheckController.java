package com.cskaoyan.controller;

import com.cskaoyan.service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/erp/fMeasureCheck")
public class MeasureCheckController {
    @Autowired
    MeasureService measureService;
    @RequestMapping("add_judge")
    public String addJudge(){
        return "measurement_add";
    }
    @RequestMapping("edit_judge")
    public String editJudge(){
        return "measurement_edit";
    }
    @RequestMapping("delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "";
    }
}
