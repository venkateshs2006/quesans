package com.spring.quesans.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.quesans.dao.SearchEngineDAO;
import com.spring.quesans.dto.SearchEngine;
import com.spring.quesans.service.SearchEngineService;

@Service("searchEngineService")
public class SearchEngineServiceImpl implements SearchEngineService {
	@Autowired
	@Qualifier("searchEngineDAO")
	private SearchEngineDAO searchEngineDAO;

	public void setSearchEngineDAO(SearchEngineDAO searchEngineDAO) {
		this.searchEngineDAO = searchEngineDAO;
	}

	@Override
	@Transactional
	public void addSearchEngine(SearchEngine s) {
		// TODO Auto-generated method stub
		this.searchEngineDAO.addSearchEngine(s);
	}

	@Override
	@Transactional
	public void updateSearchEngine(SearchEngine s) {
		// TODO Auto-generated method stub
		this.searchEngineDAO.updateSearchEngine(s);
	}

	@Override
	@Transactional
	public List<SearchEngine> listSearchEngines() {
		// TODO Auto-generated method stub
		return this.searchEngineDAO.listSearchEngines();
	}

	@Override
	@Transactional
	public SearchEngine getSearchEngineById(long id) {
		// TODO Auto-generated method stub
		return this.searchEngineDAO.getSearchEngineById(id);
	}

	@Override
	@Transactional
	public void removeSearchEngine(long id) {
		// TODO Auto-generated method stub
		this.searchEngineDAO.removeSearchEngine(id);
	}

}