package kr.java.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(300) // 100? 200? <- 더 중요한 것을 양보
public class LoggingAspect {
    @Before("execution(* kr.java.aop..controller..*(..))")
    public void beforeCall(JoinPoint jp) {
//        System.out.println("[BEFORE] %s".formatted(jp.getSignature()));
        System.out.println("[BEFORE] %s".formatted(jp.getSignature().getName()));
    }
}
