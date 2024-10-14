package edu.du.sb1010_2.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class CacheAspect {

    private Map<Long,Object> cache = new HashMap<Long,Object>();

    @Pointcut("execution(public * edu.du.sb1010_2.chap07..*(long))")
    public void cacheTarget(){
    }

    @Around("cacheTarget()")
    public Object cacheAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Long num = (Long) joinPoint.getArgs()[0];
        if(cache.containsKey(num)){
            System.out.printf("CacheAspect: find at Cache[%d]\n",num);
            return cache.get(num);
        }

        Object result = joinPoint.proceed();
        cache.put(num,result);
        System.out.printf("CacheAspect: Append at Cache[%d]\n",num);
        return result;
    }

}
