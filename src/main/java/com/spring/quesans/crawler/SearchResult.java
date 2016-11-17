package com.spring.quesans.crawler;

import java.util.Map;

public class SearchResult {
	private SearchEngineCrawler webSearchEngine;
	public String getResult(String searchEngine, String URL,String tag,String attribute,String attributeName){
		System.out.println("Search Result Class :"+searchEngine+" :"+URL+"  :"+tag+"  :"+attribute+"  :"+attributeName);
		if(searchEngine.equals("google")){
			webSearchEngine= new SearchEngineCrawler();			
			return webSearchEngine.getGoogleResult(URL, tag,attribute, attributeName);
			//return "Testing";
		}
		else if(searchEngine.equals("wikipedia")){
			webSearchEngine= new SearchEngineCrawler();
			return webSearchEngine.getWikipediaResult(URL, tag,attribute, attributeName);
		}
		else if(searchEngine.equals("bing")){
			/*webSearchEngine= new SearchEngineCrawler();
			return webSearchEngine.getBingResult(URL, tag, attribute,attributeName);*/
			return "Testing";
		}
		else if(searchEngine.equals("yahoo")){
			/*webSearchEngine= new SearchEngineCrawler();
			return webSearchEngine.getBingResult(URL, tag, attribute,attributeName);*/
			return "Testing";
		}
		else if(searchEngine.equals("duckduckgo")){
		/*	webSearchEngine= new SearchEngineCrawler();
			return webSearchEngine.getBingResult(URL, tag, attribute,attributeName);*/
			return "Testing";
		}
		else{
			return "Search Engine Not configured";
		}
	}
	public String getResult(String searchEngine, String URL,String tag,Map<String, String> attributes){
		
		if(searchEngine.equals("google")){
			webSearchEngine= new SearchEngineCrawler();			
			return webSearchEngine.getSearchContent(URL, tag,attributes);
			//return "Testing";
		}		
		else{
			return "Search Engine Not configured";
		}
	}
}
