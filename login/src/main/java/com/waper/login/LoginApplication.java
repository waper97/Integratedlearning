package com.waper.login;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wangpeng
 */
@SpringBootApplication
//@ComponentScan(basePackages = {"com.waper.login.filter"})
/**
 * mapper位置
 */
@MapperScan(basePackages = "com.waper.login.mapper")

/**
 * servcelet组件扫描
 */

@ServletComponentScan
public class LoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }

}
