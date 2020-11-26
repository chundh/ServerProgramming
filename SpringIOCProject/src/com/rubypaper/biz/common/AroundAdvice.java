package com.rubypaper.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;


// ����ó���� ����ó���� ��� �� �� �ִ�.
@Service
@Aspect
public class AroundAdvice {
	@Pointcut("execution(* com.rubypaper.biz..*Impl.*(..))") // pointcut �޼ҵ带 ���� ����������Ѵ�.
	public void allPointcut() {}
	
	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable {
		Object obj = null;
		System.out.println("--- Before Logic ---");
		StopWatch watch = new StopWatch();
		watch.start();
		
		obj = jp.proceed(); // �� �ڵ带 ȣ���ؾ� ����Ͻ� ������ ����ȴ�.
		
		watch.stop();
		System.out.println("--- After Logic ---");
		System.out.println("����Ͻ� �޼ҵ� ���� �ð�  : " + watch.getTotalTimeMillis());
		return obj;
	}
}
