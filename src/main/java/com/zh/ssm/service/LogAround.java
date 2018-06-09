package com.zh.ssm.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.logging.Logger;

public class LogAround implements MethodInterceptor {
    private Logger logger=Logger.getLogger(this.getClass().getName());
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        logger.info("执行输出日志");
       Object result= invocation.proceed();
        return result;
    }
}
