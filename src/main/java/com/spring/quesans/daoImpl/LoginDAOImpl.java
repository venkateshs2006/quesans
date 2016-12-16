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

import com.spring.quesans.dao.LoginDAO;
import com.spring.quesans.dto.LoginBean;

@Repository("LoginDAO")
public class LoginDAOImpl implements LoginDAO {

	private static final Logger logger = LoggerFactory.getLogger(LoginDAOImpl.class);
	@Autowired
	@Qualifier("hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addLogin(LoginBean qa) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(qa);
		logger.info("Person saved successfully, Person Details=" + qa);

	}

	@Override
	public void updateLogin(LoginBean qa) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(qa);
		logger.info("Person updated successfully, Person Details=" + qa);

	}

	@Override
	public List<LoginBean> listLogins() {
		Session session = this.sessionFactory.getCurrentSession();
		List<LoginBean> LoginList = session.createQuery("from Login").list();
		for (LoginBean qa : LoginList) {
			logger.info("Person List::" + qa);
		}
		return LoginList;
	}

	@Override
	public LoginBean getLoginById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		LoginBean qa = (LoginBean) session.load(LoginBean.class, new Integer(id));
		logger.info("Person loaded successfully, Person details=" + qa);
		return qa;
	}

	@Override
	public void removeLogin(int id) {

		Session session = this.sessionFactory.getCurrentSession();
		LoginBean qa = (LoginBean) session.load(LoginBean.class, new Integer(id));
		if (null != qa) {
			session.delete(qa);
		}
		logger.info("Person deleted successfully, person details=" + qa);
	}

	@Override
	public LoginBean getLoginByName(String name) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();		
		String hql = "from LoginBean where userName = :name";
		Query query = session.createQuery(hql);
		query.setString("name",name);
        if(query.list()!=null){
		if(query.list().size()!=0){
			return (LoginBean)query.list().get(0);
		}
		else{
			return null;
		}
        }
		else{
			return null;
		}
		
	}

}
