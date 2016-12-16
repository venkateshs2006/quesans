package com.spring.quesans.dao;

import java.util.List;

import com.spring.quesans.dto.SearchEngine;

public interface SearchEngineDAO {

	public void addSearchEngine(SearchEngine s);
	public void updateSearchEngine(SearchEngine s);
	public List<SearchEngine> listSearchEngines();
	public SearchEngine getSearchEngineById(long id);
	public void removeSearchEngine(long id);
}