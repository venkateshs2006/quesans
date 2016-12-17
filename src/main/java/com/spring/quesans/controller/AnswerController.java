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
import com.spring.quesans.dto.QuesAns;
import com.spring.quesans.dto.SearchEngine;
import com.spring.quesans.service.QuesAnsService;
import com.spring.quesans.service.SearchEngineService;

@Controller
public class AnswerController {
	private QuesAnsService quesAnsService;
	private SearchEngineService searchEngineService;

	@Autowired(required = true)
	@Qualifier(value = "searchEngineService")
	public void setSearchEngineService(SearchEngineService ss) {
		this.searchEngineService = ss;
	}

	@Autowired(required = true)
	@Qualifier(value = "quesAnsService")
	public void setQuesAnsService(QuesAnsService qs) {
		this.quesAnsService = qs;
	}

	@RequestMapping(value = "/getAnswer", method = RequestMethod.POST)
	public String getResult(@RequestParam("question") String question, Model model) throws Exception {
		Map<String, String> attributes = new LinkedHashMap<String, String>();
		// String question = "computer";
		List<SearchEngine> listSearchEngine = (List) this.searchEngineService.listSearchEngines();
		Map<String, String> results = new HashMap<String, String>();
		Map<String, String> exceptionResults = new HashMap<String, String>();
		SearchResult sr = new SearchResult();
		// Our DB access
		System.out.println("Before executing QuesAnsServices");
		QuesAns quesAns = this.quesAnsService.getQuesAnsByQuestion(question);
		System.out.println("Ques Ans Details :" + quesAns);
		String answer;
		if (quesAns == null) {
			answer = "Error";

		} else {
			answer = quesAns.getAnswer();
		}
		results.put("IGS DB", answer);
		System.out.println("List of Search Engine" + listSearchEngine);
		for (SearchEngine se : listSearchEngine) {
			System.out.println("Search Engine :" + se.getSearchEngineName() + "   :" + se.getSearchEngineURL()
					+ URLEncoder.encode(question, "UTF-8"));
			String output = sr.getResult(se.getSearchEngineName(),
					se.getSearchEngineURL() + URLEncoder.encode(question, "UTF-8"));

			results.put(se.getSearchEngineName(), output);

		}
		// Clean Output
		System.out.println("Before" + results.toString());
		Iterator<String> it = results.keySet().iterator();
		int index = 0;
		while (it.hasNext()) {
			index++;
			String key=it.next();
			System.out.println("Index Processed :"+index );
			if (results.get(key).equals("Error")) {
				if (key.equals("IGS DB")) {
					it.remove();
				} else {
					for (SearchEngine se : listSearchEngine) {
						if (se.getSearchEngineName().equals(key)) {
							System.out.println("else");
							results.replace(se.getSearchEngineName(), "Error", se.getSearchEngineURL() + URLEncoder.encode(question, "UTF-8"));
						//	results.put(se.getSearchEngineName(),se.getSearchEngineURL() + URLEncoder.encode(question, "UTF-8"));
						}
					}
				}

			}
		}

		System.out.println("After" + results.toString());
		model.addAttribute("results", results);
		return "answer";
	}

}
