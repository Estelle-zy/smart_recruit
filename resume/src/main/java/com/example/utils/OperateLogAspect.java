package com.example.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @Author
 * @Date 2022/5/24 21:04
 * @Version 1.0
 * @Description 切面类，AOP应用，实现日志统一管理
 **/
@Aspect
@Component
public class OperateLogAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    ThreadLocal<Long> startTime = new ThreadLocal<>();
    //定义切点
    @Pointcut(value = "execution(* com.binlog.study.aop.controller.*.*(..))")
    public void aopWebLog() {
    }
    //使用环绕通知
    @Around("aopWebLog()")
    public Object myLogger(ProceedingJoinPoint pjp) throws Throwable {
        startTime.set(System.currentTimeMillis());
        //使用ServletRequestAttributes请求上下文获取方法更多
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String className = pjp.getSignature().getDeclaringTypeName();
        String methodName = pjp.getSignature().getName();
        //使用数组来获取参数
        Object[] array = pjp.getArgs();
        ObjectMapper mapper = new ObjectMapper();
        //执行函数前打印日志
        logger.info("调用前：{}：{},传递的参数为：{}", className, methodName, mapper.writeValueAsString(array));
        logger.info("URL:{}", request.getRequestURL().toString());
        logger.info("IP地址：{}", request.getRemoteAddr());
        //调用整个目标函数执行
        Object obj = pjp.proceed();
        //执行函数后打印日志
        logger.info("调用后：{}：{},返回值为：{}", className, methodName, mapper.writeValueAsString(obj));
        logger.info("耗时：{}ms", System.currentTimeMillis() - startTime.get());
        return obj;
    }
}
