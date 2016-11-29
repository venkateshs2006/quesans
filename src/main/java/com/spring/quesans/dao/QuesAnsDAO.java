package com.spring.quesans.dao;

import java.util.List;

import com.spring.quesans.dto.QuesAns;

public interface QuesAnsDAO {
	public void addQuesAns(QuesAns qa);
	public void updateQuesAns(QuesAns qa);
	public List<QuesAns> listQuesAnss();
	public QuesAns getQuesAnsById(int id);
	public QuesAns getQuesAnsByQuestion(String ques);
	public void removeQuesAns(int id);
}