package com.rubypaper.biz.common;

import java.sql.SQLException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

// 예외 처리에 대한 구문을 모두 모아서 구현한다.
@Service
@Aspect
public class AfterThrowingAdvice {
	
//	@Pointcut("execution(* com.rubypaper.biz..*Impl.*(..))")
//	public void allPointcut() {}
	
	
	@AfterThrowing(pointcut="BoardPointcut.allPointcut()", throwing="exceptionObj")// 메소드에 어떠한 예외가 들어올지 알수 없기 때문에 최상위 클래스를 쓴다.
	public void exceptionLog(JoinPoint jp, Exception exceptionObj) {
		String method = jp.getSignature().getName(); // 클라이언트가 호출한 메소드 이름. printlog가 호출된 후 호출되는 메소드
		
		System.out.println("[ 예외처리 ] " + method +"() 메소드 수행 중 예외 발생");
		
		if(exceptionObj instanceof IllegalArgumentException) {
			System.out.println("잘못된 입력입니다.");
		} else if(exceptionObj instanceof ArithmeticException) {
			System.out.println("0으로 숫자를 나눌 수 없음");
		} else if(exceptionObj instanceof SQLException) {
			System.out.println("sql 에러");
		} else {
			System.out.println("알 수 없는 문제 발생. 프로그램을 종료합니다.");
		}
	}
}
