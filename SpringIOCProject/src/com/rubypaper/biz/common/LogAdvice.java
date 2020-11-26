package com.rubypaper.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

// Annotation�� ����ϸ� ������ ���ϴ�. aop�� �����ϱ⵵ ���ϴ�.

@Service
@Aspect // Aspect = pointcut�� advice�� ����
public class LogAdvice {
	
//	@Pointcut("execution(* com.rubypaper.biz..*Impl.*(..))") // pointcut �޼ҵ带 ���� ����������Ѵ�.
//	public void allPointcut() {} // Ư�� ��� ������ ���� �ִ� �޼ҵ尡 �ƴ�, ���� ������ ���� �����ϴ� ������ �޼ҵ��̴�.
//	// pointcut�� �������϶� ���θ� �����ϱ� ���ؼ� �ٵ� ����ִ� ������ �޼ҵ带 ������ �����.
	
	
	@Before("BoardPointcut.allPointcut()")
	public void printLog(JoinPoint jp) {
		String method = jp.getSignature().getName(); // Ŭ���̾�Ʈ�� ȣ���� �޼ҵ� �̸�. printlog�� ȣ��� �� ȣ��Ǵ� �޼ҵ�
		Object[] args = jp.getArgs(); 				 // Ŭ���̾�Ʈ�� ������ ���� ����
		
		System.out.println("< ����ó�� > " + method +"() �޼ҵ� args ���� : " + args[0].toString());
	}
}
