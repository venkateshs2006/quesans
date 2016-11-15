package com.spring.quesans.controller;

import java.util.ArrayList;
import java.util.List;

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
public class HomeController {
	private SearchEngineService searchEngineService;

	@Autowired(required = true)
	@Qualifier(value = "searchEngineService")
	public void setSearchEngineService(SearchEngineService ss) {
		this.searchEngineService = ss;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getResult(@RequestParam("question") String question, Model model) {
		List<SearchEngine> listSearchEngine = (List) this.searchEngineService.listSearchEngines();
		List<String> results = new ArrayList<String>();
		System.out.println("Get Result Method is executed.");
		SearchResult sr = new SearchResult();
		for (SearchEngine se : listSearchEngine) {
			System.out.println(se.getSearchEngineName());
			results.add(sr.getResult(se.getSearchEngineName(), se.getSearchEngineURL() + question, se.getResultTag(),
					se.getResultTagID(), se.getResultAttribute()));
		}
		model.addAttribute("results", results);
		return "answer";
	}
}