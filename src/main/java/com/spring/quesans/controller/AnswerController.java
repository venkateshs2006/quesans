package com.spring.quesans.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.quesans.crawler.SearchResult;
import com.spring.quesans.dto.SearchEngine;
import com.spring.quesans.service.SearchEngineService;

@Controller
public class AnswerController {
	private SearchEngineService searchEngineService;
	@Autowired(required = true)
	@Qualifier(value = "searchEngineService")
	public void setSearchEngineService(SearchEngineService ss) {
		this.searchEngineService = ss;
	}

	@RequestMapping(value = "/getAnswer", method = RequestMethod.POST)
	public String getResult(@RequestParam("question") String question, Model model)throws Exception {
		Map<String, String> attributes = new LinkedHashMap<String, String>();
		//String question = "computer";
		List<SearchEngine> listSearchEngine = (List) this.searchEngineService.listSearchEngines();
		Map<String,String> results = new HashMap<String, String>();		
		SearchResult sr = new SearchResult();
		System.out.println("List of Search Engine"+listSearchEngine);
		for (SearchEngine se : listSearchEngine) {	
			
			System.out.println("Search Engine :"+se.getSearchEngineName()+"   :"+ se.getSearchEngineURL() + URLEncoder.encode(question, "UTF-8") );
			results.put(se.getSearchEngineName(),sr.getResult(se.getSearchEngineName(), se.getSearchEngineURL() +URLEncoder.encode(question, "UTF-8")));			
		}
		//Clean Output
		System.out.println("Before"+results.toString());
		Iterator<String> it = results.keySet().iterator();

		while (it.hasNext())
		{
		  
		  if (results.get(it.next()).equals("Error")){
		    it.remove();
		 }
		}
		
		System.out.println("After"+results.toString());
		model.addAttribute("results", results);		
		return "answer";
	}

}

