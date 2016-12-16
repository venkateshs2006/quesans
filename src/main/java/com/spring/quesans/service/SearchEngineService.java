package com.spring.quesans.service;

import java.util.List;

import com.spring.quesans.dto.SearchEngine;

public interface SearchEngineService {

	public void addSearchEngine(SearchEngine p);
	public void updateSearchEngine(SearchEngine p);
	public List<SearchEngine> listSearchEngines();
	public SearchEngine getSearchEngineById(long id);
	public void removeSearchEngine(long id);
	
}