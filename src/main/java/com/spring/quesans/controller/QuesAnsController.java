package com.spring.quesans.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	/* Admin Controller */
	@RequestMapping(value = "/QUESSave", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("questionBean") QuesAns QuestionBean, 
			BindingResult result) {
		
		QuesAns question = QuestionBean;
		quesAnsService.addQuesAns(question);
		System.out.println("Save method");
		return new ModelAndView("redirect:/QUESAdd.html");
	}

	
	@RequestMapping(value = "/QUESAdd", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("questionBean")  QuesAns QuestionBean,
			BindingResult result) {
		System.out.println("Add method");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("questionList",  quesAnsService.listQuesAnss());
		return new ModelAndView("addQuestions", model);
	}
	
	@RequestMapping(value = "/QUESIndex", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("redirect:/QUESAdd.html");
	}
	
	
	@RequestMapping(value = "/QUESDelete", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@ModelAttribute("questionBean")  QuesAns QuestionBean,
			BindingResult result) {
		
		quesAnsService.removeQuesAns(QuestionBean.getId());
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println("Delete method");
		model.put("questionList",  quesAnsService.listQuesAnss());
		return new ModelAndView("addQuestions", model);
	}
	
	@RequestMapping(value = "/QUESEdit", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("questionBean")  QuesAns QuestionBean,
			BindingResult result) {
		System.out.println("Edit method");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("questionBean", quesAnsService.getQuesAnsById(QuestionBean.getId()));
		model.put("questionList",  quesAnsService.listQuesAnss());
		return new ModelAndView("addQuestions", model);
	}
}
