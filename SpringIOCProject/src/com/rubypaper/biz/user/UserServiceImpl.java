package com.rubypaper.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ����Ͻ� ������ impl���� ó���ϰ� dao������ ���� db���õȰ͸� �����ؾ��Ѵ�.
 * �׷��� ������ ������ ���߿� dao�� �ٲܶ� ���� �ٲ� �� �ִ�.
 * @author Chun
 *
 */

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO dao;
	
	@Override
	public void insertUser(UserVO vo) {
		dao.insertUser(vo);
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return dao.getUser(vo);
	}

}
