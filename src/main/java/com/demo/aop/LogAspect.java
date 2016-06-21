/**
 * Copyright(c) 2011-2011 by YouCredit Inc.
 * All Rights Reserved
 */
package com.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author xinxingegeya
 */
@Component
@Aspect
public class LogAspect {
    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Around(value = "@annotation(anno)")
    public Object processLog(ProceedingJoinPoint joinPoint, Log anno) {
        return null;
    }

}
