package com.spring.quesans.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring.quesans.dao.SearchEngineDAO;
import com.spring.quesans.dto.SearchEngine;

@Repository("searchEngineDAO")
public class SearchEngineDAOImpl implements SearchEngineDAO {

	private static final Logger logger = LoggerFactory.getLogger(SearchEngineDAOImpl.class);
	@Autowired
	@Qualifier("hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addSearchEngine(SearchEngine s) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(s);
		logger.info("Person saved successfully, Person Details=" + s);

	}

	@Override
	public void updateSearchEngine(SearchEngine s) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(s);
		logger.info("Person updated successfully, Person Details=" + s);

	}

	@Override
	public List<SearchEngine> listSearchEngines() {
		Session session = this.sessionFactory.getCurrentSession();
		List<SearchEngine> SearchEnginesList = session.createQuery("from SearchEngine").list();
		for (SearchEngine s : SearchEnginesList) {
			logger.info("Person List::" + s);
		}
		return SearchEnginesList;
	}

	@Override
	public SearchEngine getSearchEngineById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		SearchEngine s = (SearchEngine) session.load(SearchEngine.class, new Integer(id));
		logger.info("Person loaded successfully, Person details=" + s);
		return s;
	}

	@Override
	public void removeSearchEngine(int id) {

		Session session = this.sessionFactory.getCurrentSession();
		SearchEngine s = (SearchEngine) session.load(SearchEngine.class, new Integer(id));
		if (null != s) {
			session.delete(s);
		}
		logger.info("Person deleted successfully, person details=" + s);
	}

}
