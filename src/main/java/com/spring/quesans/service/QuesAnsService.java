package com.spring.quesans.service;

import java.util.List;

import com.spring.quesans.dto.QuesAns;

public interface QuesAnsService {

	public void addQuesAns(QuesAns qa);
	public void updateQuesAns(QuesAns qa);
	public List<QuesAns> listQuesAnss();
	public QuesAns getQuesAnsById(int id);
	public QuesAns getQuesAnsByQuestion(String ques);
	public void removeQuesAns(int id);
	
}