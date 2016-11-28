package com.spring.quesans.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.spring.quesans.crawler.SearchResult;
import com.spring.quesans.dto.SearchEngine;
import com.spring.quesans.service.SearchEngineService;

@Controller
public class HomeController {
	private SearchEngineService searchEngineService;

	@Autowired(required = true)
	@Qualifier(value = "searchEngineService")
	public void setSearchEngineService(SearchEngineService ss) {
		this.searchEngineService = ss;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	// public String getResult(@RequestParam("question") String question, Model
	// model) {
	public String getResult(Model model) {
		Map<String, String> attributes = new LinkedHashMap<String, String>();
		String question = "larry+page";
		List<SearchEngine> listSearchEngine = (List) this.searchEngineService.listSearchEngines();
		Map<String,String> results = new HashMap<String, String>();		
		SearchResult sr = new SearchResult();
		System.out.println("List of Search Engine"+listSearchEngine);
		for (SearchEngine se : listSearchEngine) {	
			System.out.println("Search Engine :"+se.getSearchEngineName()+"   :"+ se.getSearchEngineURL() + question);
			results.put(se.getSearchEngineName(),sr.getResult(se.getSearchEngineName(), se.getSearchEngineURL() + question));			
		}
		model.addAttribute("results", results);		
		return "answer";
	}
}