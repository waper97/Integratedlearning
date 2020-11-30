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


# springboo开启热部署  
        第一步：
            spring.devtools.livereload.enabled = true ：开启热部署
            
        第二步：
        
            设置一个快捷键，或者也可以用默认的ctril+F9/ctril+shift+F9;