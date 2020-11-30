package com.waper.login.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.waper.login.model.User;
import com.waper.login.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JwtUtil
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/10/21 16:23
 */
@Component
public class JwtUtil {
    private String scret;
    // 签名私钥
    private String key;
    @Resource
    UserService userService;
    /**
     * 设置过期时间5分钟
     */

    /**
     * 秘钥
     */
    public static final String PRIVATE_KEY = "WAPER97";
    public static final long EXPIRE_TIMEX = 24 * 60 * 1000;

    /**
     * 创建token
     * @param user
     * @return
     */
    public  static  Object createToken(User user){

        Map<String,Object> headMap = new HashMap<String,Object>(16);
        headMap.put("typ","JWT");
        headMap.put("alg","HS256");
        String token = null;
        Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIMEX);
        token = JWT.create().
                    withIssuer("fuck")
                    .withClaim("id",user.getId())
                    .withExpiresAt(expiresAt)
                    .sign(Algorithm.HMAC256(PRIVATE_KEY));
        return token;
        }

    /**
     * 验证token
     * @param token
     * @return
     */
    public static boolean verifyToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(PRIVATE_KEY)).withIssuer("fuck").build();
            DecodedJWT jwt =  verifier.verify(token);

            System.out.println("认证通过：");
            System.out.println("account:"+jwt.getClaim("account").asString());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            System.out.println("过期时间："+simpleDateFormat.format(jwt.getExpiresAt()));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
