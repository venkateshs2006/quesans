package com.spring.quesans.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.quesans.dao.QuesAnsDAO;
import com.spring.quesans.dto.QuesAns;
import com.spring.quesans.service.QuesAnsService;

@Service("quesAnsService")
public class QuesAnsServiceImpl implements QuesAnsService {
	@Autowired
	@Qualifier("quesAnsDAO")
	private QuesAnsDAO quesAnsDAO;

	public void setQuesAnsDAO(QuesAnsDAO quesAnsDAO) {
		this.quesAnsDAO = quesAnsDAO;
	}

	@Override
	@Transactional
	public void addQuesAns(QuesAns s) {
		// TODO Auto-generated method stub
		this.quesAnsDAO.addQuesAns(s);
	}

	@Override
	@Transactional
	public void updateQuesAns(QuesAns s) {
		// TODO Auto-generated method stub
		this.quesAnsDAO.updateQuesAns(s);
	}

	@Override
	@Transactional
	public List<QuesAns> listQuesAnss() {
		// TODO Auto-generated method stub
		return this.quesAnsDAO.listQuesAnss();
	}

	@Override
	@Transactional
	public QuesAns getQuesAnsById(int id) {
		// TODO Auto-generated method stub
		return this.quesAnsDAO.getQuesAnsById(id);
	}

	@Override
	@Transactional
	public void removeQuesAns(int id) {
		// TODO Auto-generated method stub
		this.quesAnsDAO.removeQuesAns(id);
	}

	@Override
	@Transactional
	public QuesAns getQuesAnsByQuestion(String ques) {
		// TODO Auto-generated method stub
		System.out.println("Reached QuesAnsServices Question :"+ques);
		return this.quesAnsDAO.getQuesAnsByQuestion(ques);
	}

}