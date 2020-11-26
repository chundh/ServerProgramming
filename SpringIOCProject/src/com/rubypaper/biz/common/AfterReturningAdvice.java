package com.rubypaper.biz.common;

import com.rubypaper.biz.user.UserVO;

public class AfterReturningAdvice {
	// �޼ҵ尡 ��� �Ķ���Ͱ� ������ �� �� ���� ������ Object Ÿ���� ����Ѵ�.
	public void afterLog(Object returnObj) {
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
