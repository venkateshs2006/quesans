package com.spring.quesans.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring.quesans.dao.QuesAnsDAO;
import com.spring.quesans.dto.QuesAns;

@Repository("quesAnsDAO")
public class QuesAnsDAOImpl implements QuesAnsDAO {

	private static final Logger logger = LoggerFactory.getLogger(QuesAnsDAOImpl.class);
	@Autowired
	@Qualifier("hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addQuesAns(QuesAns qa) {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println(qa.toString());
		session.saveOrUpdate(qa);
		logger.info("Person saved successfully, Person Details=" + qa);

	}

	@Override
	public void updateQuesAns(QuesAns qa) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(qa);
		logger.info("Person updated successfully, Person Details=" + qa);

	}

	@Override
	public List<QuesAns> listQuesAnss() {
		Session session = this.sessionFactory.getCurrentSession();
		List<QuesAns> QuesAnsList = session.createQuery("from QuesAns").list();
		for (QuesAns qa : QuesAnsList) {
			logger.info("Person List::" + qa);
		}
		return QuesAnsList;
	}

	@Override
	public QuesAns getQuesAnsById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		QuesAns qa = (QuesAns) session.load(QuesAns.class, new Integer(id));
		logger.info("Person loaded successfully, Person details=" + qa);
		return qa;
	}

	@Override
	public void removeQuesAns(int id) {

		Session session = this.sessionFactory.getCurrentSession();
		QuesAns qa = (QuesAns) session.load(QuesAns.class, new Integer(id));
		if (null != qa) {
			session.delete(qa);
		}
		logger.info("Person deleted successfully, person details=" + qa);
	}

	@Override
	public QuesAns getQuesAnsByQuestion(String ques) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();		
		String hql = "from QuesAns where question = :ques";
		Query query = session.createQuery(hql);
		query.setString("ques",ques);

		if(query.list().size()!=0){
			return (QuesAns)query.list().get(0);
		}
		else{
			return null;
		}
	}

}
