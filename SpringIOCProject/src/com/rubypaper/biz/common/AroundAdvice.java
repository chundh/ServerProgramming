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
//	@Pointcut("execution(* com.rubypaper.biz..*Impl.*(..))") // pointcut 메소드를 따로 선언해줘야한다.
//	public void allPointcut() {}
	
	@Around("BoardPointcut.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable {
		String method = jp.getSignature().getName(); // 클라이언트가 호출한 메소드 이름. printlog가 호출된 후 호출되는 메소드
		// JoinPoint에는 proceed()가 없다. 그래서 around에서는 ProceedingJoinPoint를 사용해야한다.
		// proceedingJoinPoint는 JoinPoint의 자식 클래스이다. Spring 특성상 ProceedingJoinPoint는 around에서만 사용할 수 있다.
		
		Object obj = null;
		System.out.println("--- Before Logic ---");
		StopWatch watch = new StopWatch();
		watch.start();
		
		obj = jp.proceed(); // 이 코드를 호출해야 비즈니스 로직이 수행된다.
		
		watch.stop();
		System.out.println("--- After Logic ---");
		System.out.println(method + "() 메소드 수행 시간  : " + watch.getTotalTimeMillis());
		return obj;
	}
}
