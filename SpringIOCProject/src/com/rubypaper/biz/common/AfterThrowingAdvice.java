package com.rubypaper.biz.common;

import java.sql.SQLException;

// ���� ó���� ���� ������ ��� ��Ƽ� �����Ѵ�.
public class AfterThrowingAdvice {
	// �޼ҵ忡 ��� ���ܰ� ������ �˼� ���� ������ �ֻ��� Ŭ������ ����.
	public void exceptionLog(Exception exceptionObj) {
		System.out.println("[ ����ó�� ] ����Ͻ� �޼ҵ� ���� �� ���� �߻�");
		
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
