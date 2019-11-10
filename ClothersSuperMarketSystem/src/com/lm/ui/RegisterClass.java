package com.lm.ui;

import com.lm.bean.User;
import com.lm.service.UserService;
import com.lm.service.impl.UserServiceImpl;
import com.lm.utils.WorkException;

public class RegisterClass extends Baseclass{
	
	public void register() throws WorkException{
		println(getString("input.username"));
		String username = input.nextLine();
		println(getString("input.password"));
		String password = input.nextLine();
		User user=new User(username, password);
		UserService userService=new UserServiceImpl();
		userService.register(user);
	}
}
