package org.dragons.core.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.dragons.core.response.GetWeatherResponse;
import org.dragons.core.response.SolveBattleResponse;
import org.dragons.core.valueobject.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class Aspects {

    @Autowired
    private GameStatistics gameStatistics;

    @Around("execution(* org.dragons.service.*.*(..))")
    public Object aroundLoggingAspect(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println(new Date());

        System.out.println("Method : " + joinPoint.getSignature().getName());
        Object[] signatureArgs = joinPoint.getArgs();
        for (Object signatureArg: signatureArgs) {
            System.out.println("Arg: " + signatureArg);
        }

        Object returnValue = joinPoint.proceed();

        System.out.println("Return value: " + returnValue);
        System.out.println();

        return returnValue;
    }

    @Around("execution(* org.dragons.service.*.*(..))")
    public Object aroundStatisticsAspect(ProceedingJoinPoint joinPoint) throws Throwable{

        Object returnValue = joinPoint.proceed();

        if (returnValue instanceof SolveBattleResponse) {
            SolveBattleResponse battleResult = (SolveBattleResponse) returnValue;
            gameStatistics.collectResultsStats(battleResult.getStatus());
        } else if (returnValue instanceof GetWeatherResponse) {
            GetWeatherResponse weatherResult = (GetWeatherResponse) returnValue;
            gameStatistics.collectWeatherStats(Weather.fromKey(weatherResult.getCode()));
        }

        return returnValue;
    }
}
