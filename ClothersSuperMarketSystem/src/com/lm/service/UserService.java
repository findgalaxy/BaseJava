package com.lm.service;

import com.lm.bean.User;
import com.lm.utils.WorkException;

public interface UserService {
	public User register(User user) throws WorkException;
	public User login(String username,String password) throws WorkException;
}
