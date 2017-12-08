package ac.cr.una.springaopexception.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger slf4jLogger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* ac.cr.una.springaopexception.service.*.*(..))")
    public void pointcutAllMethods() {

    }

    @Before("pointcutAllMethods()")
    public void logBefore(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().toString();
        String methodName = joinPoint.getSignature().getName();

        slf4jLogger.info("@Before class: " + className + " method: " + methodName);
    }

    @After("pointcutAllMethods()")
    public void logAfter(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().toString();
        String methodName = joinPoint.getSignature().getName();

        slf4jLogger.info("@After class: " + className + " method: " + methodName);
    }

    @AfterThrowing(value="pointcutAllMethods()", throwing="ex")
     public void logAfterThrowingAllMethods(Exception ex) throws Throwable {
        slf4jLogger.error("A real ERROR AfterThrowing: ", ex);
    }

}
