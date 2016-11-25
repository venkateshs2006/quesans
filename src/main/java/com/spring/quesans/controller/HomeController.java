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
		System.out.println("Get Result Method is executed.");
		SearchResult sr = new SearchResult();
		for (SearchEngine se : listSearchEngine) {
			System.out.println(se.getSearchEngineName());
			if (se.getResultAttribute().contains(",")) {
				List<String> attributeNames = Lists.newArrayList(Splitter.on(',').trimResults().split(se.getResultAttribute()));
				List<String> attributeValues = Lists.newArrayList(Splitter.on(',').trimResults().split(se.getResultTagID()));						
				int position = 0;
				for (String key : attributeNames) {
					attributes.put(key, attributeValues.get(position));
					position++;
				}							
				results.put(se.getSearchEngineName(),sr.getResult(se.getSearchEngineName(), se.getSearchEngineURL() + question,
						se.getResultTag(), attributes));
			} else {
				results.put(se.getSearchEngineName(),sr.getResult(se.getSearchEngineName(), se.getSearchEngineURL() + question,
						se.getResultTag(), se.getResultAttribute(), se.getResultTagID()));
			}
		}
		model.addAttribute("results", results);		
		return "answer";
	}
}