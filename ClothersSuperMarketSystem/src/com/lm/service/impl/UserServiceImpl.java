package com.lm.service.impl;

import com.lm.bean.User;
import com.lm.service.UserService;
import com.lm.utils.EmptyUtils;
import com.lm.utils.UserFile;
import com.lm.utils.WorkException;
public  class UserServiceImpl implements UserService{

	@Override
	public User register(User user) throws WorkException {
		UserFile userFile=new UserFile();
		userFile.add(user);
		userFile.writeUsers();
		return user;
	}

	@Override
	public User login(String username, String password) throws WorkException {
		if(EmptyUtils.isEmpty(username)) {
			throw new WorkException("username.notnull");
		}
		if(EmptyUtils.isEmpty(password)) {
			throw new WorkException("password.notnull");
		}
		UserFile userFile=new UserFile();
		User user = userFile.findByUsernamePassword(username, password);
		
		return user;
	}
}
