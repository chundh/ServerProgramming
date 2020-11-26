package com.rubypaper.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

// Annotation을 사용하면 관리가 편하다. aop를 제어하기도 편리하다.

@Service
@Aspect // Aspect = pointcut과 advice의 결합
public class LogAdvice {
	
//	@Pointcut("execution(* com.rubypaper.biz..*Impl.*(..))") // pointcut 메소드를 따로 선언해줘야한다.
//	public void allPointcut() {} // 특정 기능 수행을 위해 있는 메소드가 아닌, 무언가 구별을 위해 존재하는 참조형 메소드이다.
//	// pointcut이 여러개일때 서로를 구별하기 위해서 바디가 비어있는 참조형 메소드를 여러개 만든다.
	
	
	@Before("BoardPointcut.allPointcut()")
	public void printLog(JoinPoint jp) {
		String method = jp.getSignature().getName(); // 클라이언트가 호출한 메소드 이름. printlog가 호출된 후 호출되는 메소드
		Object[] args = jp.getArgs(); 				 // 클라이언트가 전달한 인자 정보
		
		System.out.println("< 사전처리 > " + method +"() 메소드 args 정보 : " + args[0].toString());
	}
}
