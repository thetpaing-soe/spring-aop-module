package org.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AlogCurrencyServiceAspect {

//    @Before("target(org.example.service.AlgoCurrencyService)")
    public void beforeCurrencyAdvice(JoinPoint joinPoint) {
        System.out.println("%s method invoked before with %s.".formatted(joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())));
    }
}
