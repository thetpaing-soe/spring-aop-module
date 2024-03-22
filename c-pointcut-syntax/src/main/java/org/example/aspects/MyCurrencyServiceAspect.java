package org.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MyCurrencyServiceAspect {

    @Pointcut("within(org.example.service.*)")
    public void withinPointCut() {}

    @Pointcut("@within(org.example.annotation.Secured)")
    public void annotationWithin() {}

    @Pointcut("@annotation(org.example.annotation.InTransaction)")
    public void annotationPointCut() {}

    @Pointcut("bean(myCurrencyService)")
    public void beanPointCut() {}

    @Pointcut("args(int, int)")
    public void argsPointCut() {}

    @Pointcut("@args(org.example.annotation.Secured)")
    public void annotationArgsPointCut() {}

    @Pointcut("@target(org.example.annotation.Secured)")
    public void annotationTarget() {}

//    @After("annotationTarget()")
    public void beforeCurrencyAdvice(JoinPoint joinPoint) {
        System.out.println("%s method invoked before with %s.".formatted(joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())));
    }

//    @AfterReturning(value = "annotationWithin()", returning = "value")
    public void afterReturningAdvice(JoinPoint joinPoint, String value) {
        System.out.println("AfterReturningAdvice %s method return type is %s".formatted(joinPoint.getSignature().getName(), value));
    }

//    @AfterThrowing(value = "annotationPointCut()", throwing = "exception")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception exception) {
        System.out.println("%s method throws %s exception.".formatted(joinPoint.getSignature().getName(), exception.getClass().getSimpleName()));
    }

    @Around("annotationPointCut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("Before %s method invoked.".formatted(joinPoint.getSignature().getName()));

        try {

            Object value = joinPoint.proceed();
            System.out.println("%s method's return value::%s"
                    .formatted(joinPoint.getSignature().getName(), value));
        } catch (Exception e) {

            System.out.println("%s method throws %s exception."
                    .formatted(joinPoint.getSignature().getName(), e.getClass().getSimpleName()));
        } finally {

            System.out.println("After %s method invoked."
                    .formatted(joinPoint.getSignature().getName()));
        }

        return null;
    }
}
