package com.waper.login.controller;

import com.waper.login.model.Type;
import io.swagger.annotations.Api;
import org.apache.jasper.tagplugins.jstl.core.Out;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.*;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName SpiderController
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/11/26 17:26
 */
@Api(value = "爬虫控制器")
public class SpiderController extends BaseController{


    /**访问的网站*/
    private static final String URL = "http://mzsock.com/";
    /**硬盘地址*/
    private static final String HARDDISK_PATH = "F:\\beauty";

    public static void main(String[] args) throws IOException {


        Document elements = Jsoup.parse(new URL(URL),5000);
        // 获取分类
        Elements typeList =  elements.getElementsByClass("tag-cloud-link");
        List<Type> typeArr = new ArrayList<>();
        List<Type> enterTypeArr = new ArrayList<>();

        for (int i = 0; i < typeList.size(); i++ ) {
            // url
            String href = typeList.get(i).attr("href");
            // 分类名称
            String typeName = typeList.get(i).text();
            Type type = new Type();
                type.setHref(href);
                type.setName(typeName);
            typeArr.add(type);
//            System.out.println(href);


            downloadPicture(href);
        }
        // 进入分类
        Elements enterType = elements.getElementById("chenxing_menu").getElementsByTag("a");
//        System.out.println(elements);
//        System.out.println(typeArr);
    }


    public static void downloadPicture(String url) throws IOException {







        Document elements = Jsoup.parse(new URL(url),5000);
        /// 获取每个类别图片地址
        Elements fl =  elements.select(".post-thumbnail").select("a");
        List<Type> flList = new ArrayList<>();
        for (int i = 0;i < fl.size(); i++) {
            Type type = new Type();
            type.setHref(fl.get(i).attr("href"));
            type.setName(fl.get(i).text());
            flList.add(type);
        }

        // 进入图片的url
        Document picElements = Jsoup.parse(new URL(url),5000);
        Elements imgs = picElements.getElementsByClass("post-thumbnail").select("img");
        for (int i = 0; i < imgs.size(); i++) {

            // 图片url
            String imagsUrl = imgs.get(i).attr("data-original");
            URLConnection connection = new URL(imagsUrl).openConnection();
            InputStream is = connection.getInputStream();

            String pictureName = UUID.randomUUID().toString().replace("-","");
            System.out.println(imagsUrl);

            byte [] bytes = new byte[1024];
            int tem= 0;
            OutputStream os = new FileOutputStream(new File("F:\\beauty\\"+pictureName));
            while ((tem = is.read())!= -1) {
                os.write(bytes, 0, tem);
            }
            is.close();
            os.close();
            }
//        System.out.println(picElements);
        System.out.println("下载成功");






//        File file = new File(HARDDISK_PATH);
//        // 打开连接
//        URLConnection connection = new URL(url).openConnection();
////
//
//
//        // 获取输入流
//        InputStream is = connection.getInputStream();
//        // 后缀
//        String stuff = url.substring(url.lastIndexOf("."));
//        // 图片名称
//        String pictureName = UUID.randomUUID().toString()+stuff;
//        byte [] bytes = new byte[1024];
//        int tem= 0;
//        OutputStream os = new FileOutputStream(new File("F:\\beauty"+pictureName));
//
//
//        while ((tem = is.read())!= -1) {
//            os.write(bytes, 0, tem);
//        }
//        is.close();
//        os.close();
//
//
//        System.out.println("下载成功");
    }
}
