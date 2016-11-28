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
	@RequestMapping(value = "/", method = RequestMethod.GET)
	// public String getResult(@RequestParam("question") String question, Model
	// model) {
	public String getResult(Model model) {
		return "home";
	}
}