package com.lm.ui;

import com.lm.bean.User;
import com.lm.service.UserService;
import com.lm.service.impl.UserServiceImpl;
import com.lm.utils.WorkException;

public class LoginClass extends Baseclass{
	public void login() throws WorkException{
		println(getString("input.username"));
		String username = input.nextLine();
		println(getString("input.password"));
		String password = input.nextLine();
		UserService userService=new UserServiceImpl();
		User user = userService.login(username, password);
		if(user!=null) {
			currUser=user;
		}else {
			throw new WorkException("login.error");
		}
	}
}
