package com.spring.quesans.crawler;

public class SearchResult {
	private SearchEngineCrawler webSearchEngine;
	public String getResult(String searchEngine, String URL,String tag,String attribute,String attributeName){
		if(searchEngine=="google"){
			webSearchEngine= new SearchEngineCrawler();
			return webSearchEngine.getGoogleResult(URL, tag,attribute, attributeName);
		}
		if(searchEngine.equals("wikipedia")){
			webSearchEngine= new SearchEngineCrawler();
			return webSearchEngine.getWikipediaResult(URL, tag,attribute, attributeName);
		}
		else{
			return "Error";
		}
	}

}
