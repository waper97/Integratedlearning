package com.waper.login.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @ClassName KaptchaController
 * @Description 验证码
 * @Author wangpeng
 * @Date 2020/11/30 11:11
 */
@Api(value = "验证码控制器")
@RestController
public class KaptchaController extends BaseController{

    public static Logger logger = LoggerFactory.getLogger(KaptchaController.class);
    /**
     * 随机字符串
     */
    private static  final String RANDSTR = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    // 生产随机数的数量
    private static int stringNumber = 4;
    // 宽
    private static int width = 90;
    // 高
    private static int height = 25;
    // 干扰线数量
    private static int lineSize = 4;
    static Random random = new Random();
    StringBuffer buffer = new StringBuffer();

    /**
     * 生成随机验证码
     * @param response
     */
    @ApiOperation(value = "生成验证码")
    @RequestMapping("createKaptcha")
    public  void createKaptcha(HttpServletResponse response ){
        // 设置相应类型，告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        // 设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);

        // 创建空白图片
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        // 获取图片画笔
        Graphics graphics = bufferedImage.getGraphics();
        // 设置边框颜色
        graphics.setColor(Color.WHITE);
        // 绘制矩形背景
        graphics.fillRect(0, 0, width, height);
        // 划线
        drawLine(graphics);
        // 随机字符
        randNumber(graphics);
        graphics.dispose();
        try {
            ImageIO.write(bufferedImage,"JPEG",response.getOutputStream());
        } catch (IOException e) {
            logger.info("绘制验证到客户单失败");
            e.printStackTrace();
        }
    }
    /**
     * 生成干扰线
     * @param graphics
     */
    public void drawLine(Graphics graphics){
        // 设置颜色
        graphics.setColor(getRandColor());
        for (int i = 0; i < lineSize; i++) {
            Random random = new Random();
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(13);
            int x2 = random.nextInt(15);
            graphics.drawLine(x, y, x1, x2);
        }
    }

    /**
     * 画随机字符
     */
    public void randNumber(Graphics graphics) {
        Random random = new Random();
        // 字体
        graphics.setFont(new Font("fuck",Font.ROMAN_BASELINE,18));
        String tempStr = "";
        for (int i = 0; i < stringNumber; i++) {
            int temp = random.nextInt(RANDSTR.length());
            String rand = RANDSTR.substring(temp, temp+1);
            tempStr += rand;
            // 设置颜色
            graphics.setColor(getRandColor());
            graphics.drawString(rand,13 * i, 16 );
        }
    }

    /**
     * 随机颜色
     * @return
     */
    public static Color getRandColor(){
        Random random = new Random();
        Color color = new Color(
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256));
        return color;
    }
}
