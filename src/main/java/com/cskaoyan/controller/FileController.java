
package com.cskaoyan.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@RequestMapping("/erp/file")
public class FileController {
    @RequestMapping("/upload")
    @ResponseBody
    public Map upload(MultipartFile file, HttpServletRequest request, String dir) throws IOException {
        String realPath = request.getServletContext().getRealPath("/WEB-INF/"+"file");
        String filename = file.getOriginalFilename();
        String s = Integer.toBinaryString(UUID.randomUUID().toString().hashCode());
        String newFileName=realPath+"/"+s+ filename.substring(filename.lastIndexOf("."));
        File file1 = new File(newFileName);
        if (!file1.getParentFile().exists()) {
            file1.getParentFile().mkdir();
        }
        file.transferTo(file1);
        HashMap<String, Object> uploadRsponseVo = new HashMap<>();

        String url="/file/"+s+filename.substring(filename.lastIndexOf("."));
        uploadRsponseVo.put("error",0);
        uploadRsponseVo.put("url",url);
        return uploadRsponseVo;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(String fileName,HttpServletRequest request) throws IOException {
        String realPath = request.getServletContext().getRealPath("/WEB-INF"+fileName);
        File file1 = new File(realPath);
        boolean delete = file1.delete();
        Map<String, Object> uploadRsponseVo = new HashMap<>();
        uploadRsponseVo.put("data","success");
        return uploadRsponseVo;
    }

    @RequestMapping(value ="/download")
    public ResponseEntity<byte[]> DownloadFile(HttpServletRequest req, HttpServletResponse resp,String fileName) throws ServletException, IOException {
        //  接受的是UTF-8
        req.setCharacterEncoding("utf-8");
        //获取项目根目录
        String path = req.getServletContext().getRealPath("/WEB-INF"+fileName);
        //获取文件名
        String filename =fileName.substring(fileName.lastIndexOf("/"));
        File file = null;
        HttpHeaders headers = null;
        try {
            System.out.println(filename);//myfiles
            file = new File(path);
            headers = new HttpHeaders();
            String fileName1 = new String(filename.getBytes("UTF-8"), "iso-8859-1");//解决文件名乱码
//通知浏览器以attachment（下载方式）打开图片
            headers.setContentDispositionFormData("attachment", fileName1);
//application/octet-stream二进制流数据（最常见的文件下载）。
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }
}



