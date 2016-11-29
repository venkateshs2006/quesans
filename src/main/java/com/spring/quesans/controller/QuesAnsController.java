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
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.spring.quesans.dto.QuesAns;
import com.spring.quesans.service.QuesAnsService;

@Controller
public class QuesAnsController {
	private QuesAnsService quesAnsService;

	@Autowired(required = true)
	@Qualifier(value = "quesAnsService")
	public void setQuesAnsService(QuesAnsService ss) {
		this.quesAnsService = ss;
	}

	@RequestMapping(value = "/getQuesAns", method = RequestMethod.GET)
	public String listPersons(Model model) {
		List listQuesAns = (List) this.quesAnsService.listQuesAnss();
		System.out.println("List Search Engine :" + listQuesAns.toString());
		model.addAttribute("listQuesAns", listQuesAns);
		return "quesans";
	}

	@RequestMapping(value = "/getMachedQuestion", method = RequestMethod.GET)
	@ResponseBody
	public String listQuestion(@RequestParam(required = false, value = "term") String name) {
		List<QuesAns> listQuesAns = (List) this.quesAnsService.listQuesAnss();
		List<String> matchQuestions = new ArrayList<String>();
		
		for (QuesAns quesAns : listQuesAns) {
			System.out.println(quesAns.getQuestion().toLowerCase());
			System.out.println((quesAns.getQuestion().toLowerCase()).indexOf((name.toLowerCase())));
			if ((quesAns.getQuestion().toLowerCase()).indexOf((name.toLowerCase()))>=0) {	
				System.out.println("If Condition Executed");
				matchQuestions.add(quesAns.getQuestion());
			}
		}
		System.out.println("List of Question :"+matchQuestions.toString());
		// model.addAttribute("listQuesAns",listQuesAns);
		Gson gson = new Gson();
		return gson.toJson(matchQuestions);
		// return "quesans";
	}
}
