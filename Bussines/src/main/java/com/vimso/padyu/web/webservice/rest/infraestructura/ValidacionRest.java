package com.vimso.padyu.web.webservice.rest.infraestructura;

import javax.inject.Named;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

//@Named
//@Aspect
public class ValidacionRest
{
  @Around("execution(@org.springframework.web.bind.annotation.RequestMapping * *(..))")
  public Object time(ProceedingJoinPoint pjp) throws Throwable
  {
    long start = System.nanoTime();
    Object result = pjp.proceed();
    long end= System.nanoTime();
 
    long duration = end - start;
 
    System.out.println("Duration: " + duration + "nano secs.");
    return result;
  }
 
}
