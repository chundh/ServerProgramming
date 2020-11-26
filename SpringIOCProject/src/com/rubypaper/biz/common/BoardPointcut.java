package com.rubypaper.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


// 각 클래스에서 공통적으로 사용될 pointcut을 하나의 클래스로 묶어서 관리한다.

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
