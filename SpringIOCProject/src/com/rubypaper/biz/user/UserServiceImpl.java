package com.rubypaper.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 비즈니스 로직을 impl에서 처리하고 dao에서는 오직 db관련된것만 관리해야한다.
 * 그렇게 역할을 나눠야 나중에 dao를 바꿀때 쉽게 바꿀 수 있다.
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
