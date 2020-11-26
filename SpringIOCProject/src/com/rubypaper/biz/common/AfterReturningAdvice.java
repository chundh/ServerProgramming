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
	public void afterLog(Object returnObj) {// 메소드가 어떠한 파라미터가 들어올지 알 수 없기 때문에 Object 타입을 사용한다.
		if(returnObj==null) { // returnObj에 Object가 들어올 수도 있고, void 메소드에 의해 null이 들어올 수 있다.
			return;
		}
		System.out.println("[ 사후처리 ] 비즈니스 메소드 리턴 값: " + returnObj.toString());
		
		// 해당 조건문으로 returnObj의 타입을 나눠서 처리할 수 있다.
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("ADMIN")) {
				System.out.println(user.getName() + "님은 관리자 화면으로 이동합니다");
			}
		}
	}
}
