package com.centimeassignment.first.service.annotation;

import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Aspect
@Component
public class MethodParamsAdvice {

    Logger logger = LoggerFactory.getLogger(MethodParamsAdvice.class);
    Gson gson = new Gson();

    @Around("@annotation(com.centimeassignment.first.service.annotation.LogMethodParam)")
    public Object methodArgs(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

       Object obj =  proceedingJoinPoint.proceed();
       String[] argNames = ((MethodSignature) proceedingJoinPoint.getSignature()).getParameterNames();
        Object[] values = proceedingJoinPoint.getArgs();
        Map<String, Object> params = new HashMap<>();
        if (argNames.length != 0) {
            for (int i = 0; i < argNames.length; i++) {
                params.put(argNames[i], values[i]);
            }
        }
       logger.info("Method" + proceedingJoinPoint.getSignature() + " Params " +gson.toJson(params));
       return obj ;

    }

}
