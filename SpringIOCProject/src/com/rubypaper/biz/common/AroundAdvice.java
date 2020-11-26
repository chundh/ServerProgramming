package com.rubypaper.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;


// 사전처리와 사후처리를 모두 할 수 있다.
@Service
@Aspect
public class AroundAdvice {
	@Pointcut("execution(* com.rubypaper.biz..*Impl.*(..))") // pointcut 메소드를 따로 선언해줘야한다.
	public void allPointcut() {}
	
	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable {
		Object obj = null;
		System.out.println("--- Before Logic ---");
		StopWatch watch = new StopWatch();
		watch.start();
		
		obj = jp.proceed(); // 이 코드를 호출해야 비즈니스 로직이 수행된다.
		
		watch.stop();
		System.out.println("--- After Logic ---");
		System.out.println("비즈니스 메소드 수행 시간  : " + watch.getTotalTimeMillis());
		return obj;
	}
}
