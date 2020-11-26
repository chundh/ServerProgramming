package com.rubypaper.biz.common;

import java.sql.SQLException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

// ���� ó���� ���� ������ ��� ��Ƽ� �����Ѵ�.
@Service
@Aspect
public class AfterThrowingAdvice {
	
//	@Pointcut("execution(* com.rubypaper.biz..*Impl.*(..))")
//	public void allPointcut() {}
	
	
	@AfterThrowing(pointcut="BoardPointcut.allPointcut()", throwing="exceptionObj")// �޼ҵ忡 ��� ���ܰ� ������ �˼� ���� ������ �ֻ��� Ŭ������ ����.
	public void exceptionLog(JoinPoint jp, Exception exceptionObj) {
		String method = jp.getSignature().getName(); // Ŭ���̾�Ʈ�� ȣ���� �޼ҵ� �̸�. printlog�� ȣ��� �� ȣ��Ǵ� �޼ҵ�
		
		System.out.println("[ ����ó�� ] " + method +"() �޼ҵ� ���� �� ���� �߻�");
		
		if(exceptionObj instanceof IllegalArgumentException) {
			System.out.println("�߸��� �Է��Դϴ�.");
		} else if(exceptionObj instanceof ArithmeticException) {
			System.out.println("0���� ���ڸ� ���� �� ����");
		} else if(exceptionObj instanceof SQLException) {
			System.out.println("sql ����");
		} else {
			System.out.println("�� �� ���� ���� �߻�. ���α׷��� �����մϴ�.");
		}
	}
}
