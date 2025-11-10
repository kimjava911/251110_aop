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
    // point cut, advice
    // execution(* kr.java.aop.controller..*(..))
    // * -> 반환 타입에 따른 것
    // kr.java.aop.controller.. -> 패키지 경로. * => 와일드카드
    // . -> 정확하게. ..은 중간은 무시하겠다
    // *(..) - 메서드이름(매개변수)
//    @Before("execution(* kr.java.aop.controller..*(..))")
    @Before("within(kr.java.aop.controller.*)") // kr.java.aop.controller 안에 있는 모든 클래스 내부의 메서드들...
    // @Before <- Advice.
    public void beforeCall(JoinPoint jp) {
//        System.out.println("[BEFORE] %s".formatted(jp.getSignature()));
//        System.out.println("[BEFORE] %s".formatted(jp.getSignature().getName()));
        System.out.println("[BEFORE+within] %s".formatted(jp.getSignature().getName()));
    }

    @Before("execution(* kr.java.aop.controller..*(..))")
    public void beforeCall2(JoinPoint jp) {
        System.out.println("[BEFORE+execution] %s".formatted(jp.getSignature().getName()));
    }

    @Before("execution(* kr.java.aop.controller..index(..))")
    public void beforeIndex(JoinPoint jp) {
        System.out.println("[BEFORE] 이건 인덱스와 관련");
    }

    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void beforeGetMapping() {
        System.out.println("[BEFORE+@annotation] GET Mapping 달림");
    }

    @Before("@within(org.springframework.stereotype.Service)")
    public void beforeService() {
        System.out.println("[BEFORE+@within] Service 달림");
    }

}
