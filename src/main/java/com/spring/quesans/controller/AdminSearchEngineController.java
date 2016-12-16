package com.spring.quesans.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.quesans.dto.SearchEngine;
import com.spring.quesans.service.SearchEngineService;


@Controller
public class AdminSearchEngineController {

		@Autowired
		private SearchEngineService searchEngineService;
		
		@RequestMapping(value = "/SESave", method = RequestMethod.POST)
		public ModelAndView saveEmployee(@ModelAttribute("searchEngine") SearchEngine searchEngineBean, 
				BindingResult result) {
			
			SearchEngine searchEngine = searchEngineBean;
			searchEngineService.addSearchEngine(searchEngine);
			System.out.println("Save method");
			return new ModelAndView("redirect:/SEAdd.html");
		}

		
		@RequestMapping(value = "/SEAdd", method = RequestMethod.GET)
		public ModelAndView addEmployee(@ModelAttribute("searchEngine")  SearchEngine searchEngineBean,
				BindingResult result) {
			System.out.println("Add method");
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("searchEngineList",  searchEngineService.listSearchEngines());
			return new ModelAndView("addSearchEngine", model);
		}
		
		@RequestMapping(value = "/SEIndex", method = RequestMethod.GET)
		public ModelAndView welcome() {
			return new ModelAndView("redirect:/SEAdd.html");
		}
		
		
		@RequestMapping(value = "/SEDelete", method = RequestMethod.GET)
		public ModelAndView deleteEmployee(@ModelAttribute("searchEngine")  SearchEngine searchEngineBean,
				BindingResult result) {
			
			searchEngineService.removeSearchEngine((int)searchEngineBean.getId());
			Map<String, Object> model = new HashMap<String, Object>();
			System.out.println("Delete method");
			model.put("searchEngineList",  searchEngineService.listSearchEngines());
			return new ModelAndView("addSearchEngine", model);
		}
		
		@RequestMapping(value = "/SEEdit", method = RequestMethod.GET)
		public ModelAndView editEmployee(@ModelAttribute("searchEngine")  SearchEngine searchEngineBean,
				BindingResult result) {
			System.out.println("Edit method");
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("searchEngine", searchEngineService.getSearchEngineById((long) searchEngineBean.getId()));
			model.put("searchEngineList",  searchEngineService.listSearchEngines());
			return new ModelAndView("addSearchEngine", model);
		}
			
}
