package com.spring.quesans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.quesans.service.QuesAnsService;
@Controller
public class QuesAnsController {
private QuesAnsService quesAnsService;
	
	@Autowired(required=true)
	@Qualifier(value="quesAnsService")
	public void setQuesAnsService(QuesAnsService ss){
		this.quesAnsService = ss;
	}
	@RequestMapping(value = "/getQuesAns", method = RequestMethod.GET)
	public String listPersons(Model model) {	
		List listQuesAns=(List) this.quesAnsService.listQuesAnss();
		System.out.println("List Search Engine :"+listQuesAns.toString());
		model.addAttribute("listQuesAns",listQuesAns);		
		return "quesans";
	}
	
}
