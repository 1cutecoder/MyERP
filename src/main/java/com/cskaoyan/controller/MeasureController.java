package com.cskaoyan.controller;

import com.cskaoyan.bean.CodeType;
import com.cskaoyan.bean.FinalMeasuretCheck;
import com.cskaoyan.bean.ResponseVo;
import com.cskaoyan.service.MeasureService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/erp/measure")
public class MeasureController {
    @Autowired
    MeasureService measureService;
    @RequestMapping("find")
    public String measueFind(){
        return "measurement_list";
    }
    @RequestMapping("list")
    @ResponseBody
    public ResponseVo find(int page,int rows){
        PageHelper.startPage(page,rows);
        List<FinalMeasuretCheck> allMeasure = measureService.findAllMeasure(page, rows);
        int total = (int)measureService.selectTotalCount();
        ResponseVo responseVo = new ResponseVo();
        responseVo.setRows(allMeasure);
        responseVo.setTotal(total);
        return responseVo;
    }
    @RequestMapping("add")
    public String add(){
        return "measurement_add";
    }
    @RequestMapping("insert")
    @ResponseBody
    public CodeType insert(FinalMeasuretCheck finalMeasuretCheck){
        int i = measureService.addMeasurement(finalMeasuretCheck);
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
    public String edit(){
        return "measurement_edit";
    }
    @RequestMapping("update_all")
    @ResponseBody
    public CodeType update(FinalMeasuretCheck finalMeasuretCheck) {
        int i = measureService.updateMeasurement(finalMeasuretCheck);
        CodeType codeType = new CodeType();
        if (i != 0) {
            codeType.setMsg("OK");
            codeType.setStatus("200");
            codeType.setData(null);
        } else {
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
        int i = measureService.deleteMeasurementById(ids);
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
    @RequestMapping("search_fMeasureCheck_by_fMeasureCheckId")
    @ResponseBody
    public ResponseVo searchMeasureById(String searchValue ,int page,int rows){
        List<FinalMeasuretCheck> finalMeasuretChecks = measureService.searchMeasureById(searchValue, page, rows);
        ResponseVo responseVo = new ResponseVo();
        responseVo.setRows(finalMeasuretChecks);
        responseVo.setTotal(finalMeasuretChecks == null ? 0 : finalMeasuretChecks.size());
        return responseVo;
    }
    @RequestMapping("search_fMeasureCheck_by_orderId")
    @ResponseBody
    public ResponseVo searchMeasureByOid(String searchValue ,int page,int rows){
        List<FinalMeasuretCheck> finalMeasuretChecks = measureService.searchMeasureByOid(searchValue, page, rows);
        ResponseVo responseVo = new ResponseVo();
        responseVo.setRows(finalMeasuretChecks);
        responseVo.setTotal(finalMeasuretChecks == null ? 0 : finalMeasuretChecks.size());
        return responseVo;
    }
}
