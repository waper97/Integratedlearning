#session和cookie介绍：

#filte 拦截的两种方式
注解注册法:
 ```
     在过滤器上添加WebFilter注解
     在启动类添加ServletComponentScan注解：
      

```

```java
@WebFilter(filterName = "SessionFilter",urlPatterns = "{/*}")
      public class SessionFilter  implements Filter {
```

```java



/**
 * @author wangpeng
 */
@SpringBootApplication
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

```


![11](https://github.com/waper97/picture/blob/main/Image_for_documentation/%E8%B7%A8%E5%9F%9F.png)

# springboo开启热部署  
        第一步：
            spring.devtools.livereload.enabled = true ：开启热部署
            
        第二步：
        
            设置一个快捷键，或者也可以用默认的ctril+F9/ctril+shift+F9;
            
## swagger2
 文档地址：
```
   http://localhost:5555/swagger-ui/index.html(ip+端口+swagger-ui/index.html)
```
![sss](https://raw.githubusercontent.com/waper97/picture/main/Image_for_documentation/swagger2_original.png)
 增强版(加上knife4j)
 knife4j-spring-boot-starter
![人脸识别仪](https://raw.githubusercontent.com/waper97/picture/main/swagger2forKni4h.png)