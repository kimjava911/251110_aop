package kr.java.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
    public void beforeService(JoinPoint jp) {
        System.out.println("[BEFORE+@within] Service 달림 %s".formatted(jp.getSignature().getName()));
    }

    @Before("@within(org.springframework.stereotype.Service) && args(String)")
    public void beforeServiceString(JoinPoint jp) {
        System.out.println("[BEFORE+@within] Service + String 포함 %s".formatted(jp.getSignature().getName()));
    }

    // 포인트컷 조합
    // && -> and, || -> or, ! -> not
//    @Pointcut("exeuction(* kr.java.aop..service..*(..))") // 메서드
    @Pointcut("within(kr.java.aop..service.*)") // 클래스
//    @Pointcut("@within(org.springframework.stereotype.Service)")
    private void serviceLayer() {}

    @Pointcut("@within(org.springframework.stereotype.Controller)")
    private void controllerLayer() {}

    @Pointcut("args(String, ..)")
    private void argsString() {}

    @Before("serviceLayer() && argsString()")
    public void serviceWithString(JoinPoint jp) {
        System.out.println(jp);
        // 서비스 계층의 String을 포함한 메서드
        System.out.println("서비스 계층의 String을 포함한 메서드 (포인트컷 조합)");
    }

    @Before("serviceLayer() || controllerLayer()")
    public void serviceOrController(JoinPoint jp) {
        System.out.println(jp);
        System.out.println("서비스나 컨트롤러 계층");
    }

    @Before("serviceLayer() && !argsString()")
    public void serviceWithNotString(JoinPoint jp) {
        System.out.println(jp);
        // 서비스 계층의 String을 포함한 메서드
        System.out.println("서비스 계층의 String을 포함하지 않은 메서드 (포인트컷 조합)");
    }
}
