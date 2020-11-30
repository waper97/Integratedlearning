package com.waper.login.config;

import com.zhenzi.sms.ZhenziSmsClient;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ZhenzhiSmsUtil
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/11/24 15:01
 */
public class ZhenzhiSmsUtil {
    /**
     * 个人开发者使用https://sms_developer.zhenzikj.com，企业开发者使用https://sms.zhenzikj.com
     */
    public static final String apiUrl = "https://sms_developer.zhenzikj.com";
    public static final String appId = "107255";
    public static final String appSecret = "61c7e18d-2f91-4ce2-bc8b-c71481469c65";
    ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);

    public static void SendSms(String mobile) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>(16);
        params.put("number", mobile);
        // 短信模板id
        params.put("templateId", "2422");

        String[] templateParams = new String[2];
        templateParams[0] = "3421";
        templateParams[1] = "5分钟";
        params.put("templateParams", templateParams);
        ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
//        String result = client.send(params);
        String result1 = client.findSmsByMessageId("2422");
        String balance = client.balance();

//        System.out.println(result);
        System.out.println("短信余额:"+balance);

    }

    public static void main(String[] args) {
        try {
            SendSms("18302392883");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
