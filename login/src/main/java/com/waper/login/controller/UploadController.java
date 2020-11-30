package com.waper.login.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName UploadController
 * @Description 文件上传
 * @Author wangpeng
 * @Date 2020/11/24 10:37
 */
//@RequestMapping("api/upload")
@RestController
public class UploadController extends BaseController {

  public static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);
    /**
     * 测试
     */
    @RequestMapping("uploadTest")
    public Object uploadTest(){
        return "upload";
    }

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @RequestMapping("upload")
    public Object upload(@RequestParam("file") MultipartFile file, HttpServletRequest request){

        if (file.isEmpty()) {
              return faild("文件不能为空！");
        }
        // 文件名称
        String fileName = file.getOriginalFilename();
        // 根目录
        String filePath = request.getServletContext().getRealPath("/");

        File file1 = new File(filePath+fileName);
        try {
            file.transferTo(file1);
            LOGGER.info("上传成功");
            return success("上传成功!");
        } catch (IOException e) {
            LOGGER.info(e.toString(), e);
            e.printStackTrace();
            return success("上传成功!");
        }
    }
}
