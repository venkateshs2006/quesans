package com.spring.quesans.service;

import java.util.List;

import com.spring.quesans.dto.LoginBean;

public interface LoginService {

	public void addLogin(LoginBean qa);
	public void updateLogin(LoginBean qa);
	public List<LoginBean> listLogins();
	public LoginBean getLoginById(int id);
	public LoginBean getLoginByName(String name);
	public void removeLogin(int id);
	
}