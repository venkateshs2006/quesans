package com.spring.quesans.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.quesans.dao.LoginDAO;
import com.spring.quesans.dto.LoginBean;
import com.spring.quesans.service.LoginService;



@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	@Qualifier("LoginDAO")
	private LoginDAO LoginDAO;

	public void setLoginDAO(LoginDAO LoginDAO) {
		this.LoginDAO = LoginDAO;
	}

	@Override
	@Transactional
	public void addLogin(LoginBean s) {
		// TODO Auto-generated method stub
		this.LoginDAO.addLogin(s);
	}

	@Override
	@Transactional
	public void updateLogin(LoginBean s) {
		// TODO Auto-generated method stub
		this.LoginDAO.updateLogin(s);
	}

	@Override
	@Transactional
	public List<LoginBean> listLogins() {
		// TODO Auto-generated method stub
		return this.LoginDAO.listLogins();
	}

	@Override
	@Transactional
	public LoginBean getLoginById(int id) {
		// TODO Auto-generated method stub
		return this.LoginDAO.getLoginById(id);
	}

	@Override
	@Transactional
	public void removeLogin(int id) {
		// TODO Auto-generated method stub
		this.LoginDAO.removeLogin(id);
	}

	@Override
	@Transactional
	public LoginBean getLoginByName(String name) {
		// TODO Auto-generated method stub
		System.out.println("Reached LoginServices Question :"+name);
		return this.LoginDAO.getLoginByName(name);
	}

}