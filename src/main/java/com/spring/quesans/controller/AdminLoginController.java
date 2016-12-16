package com.spring.quesans.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.quesans.dto.LoginBean;
import com.spring.quesans.service.LoginService;

@Controller
public class AdminLoginController {
	@Autowired
	private LoginService loginService;
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response,
			HttpSession httpSession) {
		
		if (httpSession.getAttribute("userName") == "Admin") {
			return new ModelAndView("redirect:/QUESIndex");
		} else {

			ModelAndView model = new ModelAndView("login");
			LoginBean loginBean = new LoginBean();
			model.addObject("loginBean", loginBean);
			return model;
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView getLogout(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) {
			httpSession.setAttribute("userName", "");
			ModelAndView model = new ModelAndView("login");
			LoginBean loginBean = new LoginBean();
			model.addObject("loginBean", loginBean);
			return model;
		
	}

	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession,
			@ModelAttribute("loginBean") LoginBean loginBean) {
		ModelAndView model = null;
		try {
			System.out.println("Login Values :"+loginBean.toString());
			
			boolean isValidUser = isValidUser(loginBean.getUserName(), loginBean.getPassword());
			if (isValidUser) {
				System.out.println("User Login Successful");
				request.setAttribute("loggedInUser", loginBean.getUserName());
				httpSession.setAttribute("userName", "Admin");
				return new ModelAndView("redirect:/QUESIndex");
			} else {
				model = new ModelAndView("login");
				model.addObject("loginBean", loginBean);
				request.setAttribute("message", "ERROR: Invalid username and/or password.");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;
	}

	private boolean isValidUser(String userName, String password) {
		// TODO Auto-generated method stub
		//Login login=new Login();
		LoginBean login=loginService.getLoginByName(userName);
		if (userName.equals(login.getUserName()) && password.equals(login.getPassword())) {
			return true;
		} else {
			return false;
		}

	}
}
