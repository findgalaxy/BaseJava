package com.lm.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.lm.bean.User;

//用户文件,将其写入用户列表
public class UserFile {
	private static List<User> users=new ArrayList<>();
	private static final String USER_FILE="user.obj";
	public boolean writeUsers() throws WorkException{
		try {
			ObjectOutputStream outputStream=
					new ObjectOutputStream(new FileOutputStream(USER_FILE));
			outputStream.writeObject(users);
			outputStream.close();
		} catch (IOException e) {
			throw new WorkException("file.write.error");
		} 
		return true;//在添加自定异常后要改为TRUE!!!!!!!!玛德，又忘记了
	}
	//读取用户信息
	public boolean readUsers() throws WorkException{
		try {
			ObjectInputStream inputStream=
					new ObjectInputStream(new FileInputStream(USER_FILE));
			users= (List<User>)inputStream.readObject();//强制读表
			inputStream.close();
			return true;
		} catch (IOException|ClassNotFoundException e) {
			throw new WorkException("file.read.error");
		} 
		//return false;在自定义异常后，省略，
	}
	
	//添加用户
	public void add(User user) {
		user.setId(users.size()+1);
		users.add(user);
	}
	//查询用户
	public User findByUsernamePassword(String username,String password) {
		for(User u:users) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;
	}
}
