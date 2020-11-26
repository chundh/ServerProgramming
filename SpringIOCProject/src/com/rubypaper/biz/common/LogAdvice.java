package com.rubypaper.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

// Annotation�� ����ϸ� ������ ���ϴ�. aop�� �����ϱ⵵ ���ϴ�.

@Service
@Aspect // Aspect = pointcut�� advice�� ����
public class LogAdvice {
	
	@Pointcut("execution(* com.rubypaper.biz..*Impl.*(..))") // pointcut �޼ҵ带 ���� ����������Ѵ�.
	public void allPointcut() {} // Ư�� ��� ������ ���� �ִ� �޼ҵ尡 �ƴ�, ���� ������ ���� �����ϴ� ������ �޼ҵ��̴�.
	// pointcut�� �������϶� ���θ� �����ϱ� ���ؼ� �ٵ� ����ִ� ������ �޼ҵ带 ������ �����.
	
	@Before("allPointcut()")
	public void printLog() {
		System.out.println("< ����ó�� > ����Ͻ� ���� ���� �� ����");
	}
}
