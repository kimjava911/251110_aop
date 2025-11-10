package kr.java.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "kr.java.aop") // @Component 계열을 스캔
@EnableAspectJAutoProxy(proxyTargetClass = true) // Interface가 아닌 빈(bean)도 프록시 가능하게 하는 설정
public class AppConfig {
}
