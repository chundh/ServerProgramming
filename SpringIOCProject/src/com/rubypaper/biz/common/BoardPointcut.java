package com.rubypaper.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


// �� Ŭ�������� ���������� ���� pointcut�� �ϳ��� Ŭ������ ��� �����Ѵ�.

@Aspect
public class BoardPointcut {
	
	@Pointcut("execution(* com.rubypaper.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Pointcut("execution(* com.rubypaper.biz..*Impl.get*(..))")
	public void getPointcut() {}
	
	@Pointcut("execution(* com.rubypaper.biz.user.*Impl.*(..))")
	public void userPointcut() {}
	
	@Pointcut("execution(* com.rubypaper.biz.board.*Impl.*(..))")
	public void boardPointcut() {}
	
}
