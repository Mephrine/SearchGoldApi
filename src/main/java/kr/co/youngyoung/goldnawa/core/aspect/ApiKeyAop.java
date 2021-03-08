package kr.co.youngyoung.goldnawa.core.aspect;

import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApiKeyAop {
    Logger logger = LoggerFactory.getLogger(getClass());

    /*@Pointcut("@annotation(kr.co.youngyoung.goldnawa.core.annotation.ApiVersion)")
    public void getApiVersion(){}*/

    @Around("@annotation(kr.co.youngyoung.goldnawa.core.annotation.ApiVersion)")
    public Object apiCheck(ProceedingJoinPoint joinPoint) throws Throwable{
        String methodName = joinPoint.getSignature().toShortString();


        try{
            logger.info("method {} is start", methodName);
            Object obj = joinPoint.proceed();

            return  obj;
        }finally {
            logger.info("method {} is finish", methodName);
        }
    }
}
