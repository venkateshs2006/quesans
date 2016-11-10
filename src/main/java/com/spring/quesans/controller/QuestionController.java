package com.spring.quesans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.quesans.service.SearchEngineService;
@Controller
public class QuestionController {
private SearchEngineService searchEngineService;
	
	@Autowired(required=true)
	@Qualifier(value="searchEngineService")
	public void setSearchEngineService(SearchEngineService ss){
		this.searchEngineService = ss;
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listPersons(Model model) {	
		List listSearchEngine=(List) this.searchEngineService.listSearchEngines();
		System.out.println("List Search Engine :"+listSearchEngine.toString());
		model.addAttribute("listSearchEngine",listSearchEngine);		
		return "home";
	}
	
}
