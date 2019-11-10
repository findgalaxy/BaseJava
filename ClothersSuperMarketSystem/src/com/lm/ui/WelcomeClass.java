package com.lm.ui;

import com.lm.utils.UserFile;
import com.lm.utils.WorkException;

public class WelcomeClass extends Baseclass{
	public void start() {
		println(getString("info.welcome"));
		//初始化........妈蛋！！！！
		UserFile userFile=new UserFile();
		userFile.readUsers();
		boolean flag=true;
		while(flag) {
			println(getString("info.login.reg"));
			println(getString("info.select"));
			String select = input.nextLine();
			switch(select) {
			case "1":
				flag=false;
				//System.out.println("登录");
				try {
				new LoginClass().login();
				flag=false;
				println(getString("login.success"));
				}catch (WorkException e) {
					println(getString(e.getMessage()));
				}
				break;
			case "2":
				flag=false;
				//System.out.println("注册")；
				try {
				new RegisterClass().register();
				println(getString("reg.success"));
				flag=false;
				}catch(WorkException e) {
					println(getString("reg.error"));
				}
				
				break;
			default:
				println(getString("input.error"));
				break;
			}
		}
		
		//调用显示的方法
		HomePageClass homePageClass=new HomePageClass();
		homePageClass.show();
	}
}
