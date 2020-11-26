package com.rubypaper.biz.common;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.rubypaper.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {
	
//	@Pointcut("execution(* com.rubypaper.biz..*Impl.get*(..))")
//	public void getPointcut() {};
	
	@AfterReturning(pointcut="BoardPointcut.getPointcut()", returning="returnObj")
	public void afterLog(Object returnObj) {// �޼ҵ尡 ��� �Ķ���Ͱ� ������ �� �� ���� ������ Object Ÿ���� ����Ѵ�.
		if(returnObj==null) { // returnObj�� Object�� ���� ���� �ְ�, void �޼ҵ忡 ���� null�� ���� �� �ִ�.
			return;
		}
		System.out.println("[ ����ó�� ] ����Ͻ� �޼ҵ� ���� ��: " + returnObj.toString());
		
		// �ش� ���ǹ����� returnObj�� Ÿ���� ������ ó���� �� �ִ�.
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("ADMIN")) {
				System.out.println(user.getName() + "���� ������ ȭ������ �̵��մϴ�");
			}
		}
	}
}
