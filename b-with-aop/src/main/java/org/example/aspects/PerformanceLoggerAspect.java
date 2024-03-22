package org.example.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceLoggerAspect {

    // pointcut
    @Around("@target(org.example.annotation.PerformanceMetric)")
    public Object performanceAspect(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        try {
            return joinPoint.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("%s method take times %s milliseconds.".formatted(joinPoint.getSignature().getName(), (endTime - startTime)));
        }
    }
}
