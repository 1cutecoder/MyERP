
package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * Created by cute coder
 * 2019/5/18 20:02
 * 图片上传先留着
 */

@Controller
@RequestMapping("/erp/pic")
public class PictureController {
    @RequestMapping("/upload")
    @ResponseBody
    public Map upload(MultipartFile uploadFile, HttpServletRequest request, String dir) throws IOException {
        String realPath = request.getServletContext().getRealPath("/WEB-INF/"+dir);
        String filename = uploadFile.getOriginalFilename();
        String s = Integer.toBinaryString(UUID.randomUUID().toString().hashCode());
        String newFileName=realPath+"/"+s+ filename.substring(filename.lastIndexOf("."));
        File file = new File(newFileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdir();
        }
        uploadFile.transferTo(file);
        HashMap<String, Object> uploadRsponseVo = new HashMap<>();

        String url="/"+dir+"/"+s+filename.substring(filename.lastIndexOf("."));
        uploadRsponseVo.put("error",0);
        uploadRsponseVo.put("url",url);
        return uploadRsponseVo;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(String picName,HttpServletRequest request) throws IOException {
        String realPath = request.getServletContext().getRealPath("/WEB-INF"+picName);
        File file1 = new File(realPath);
        boolean delete = file1.delete();
        Map<String, Object> uploadRsponseVo = new HashMap<>();
        uploadRsponseVo.put("data","success");
        return uploadRsponseVo;
    }
}

