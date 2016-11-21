package com.spring.quesans.crawler;

import java.util.LinkedHashMap;
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
			webSearchEngine= new SearchEngineCrawler();
			Map<String, Map<String, String>> tagWithattributes=new LinkedHashMap<String,Map<String,String>>();
			Map<String, String> attributes1=new LinkedHashMap<String, String>();
			attributes1.put("class"," b_entityTitle");
			tagWithattributes.put("h2",attributes1);
			Map<String, String> attributes2=new LinkedHashMap<String, String>();
			attributes2.put("class","b_entitySubTitle");
			tagWithattributes.put("div", attributes2);
			return webSearchEngine.getBingResultContent(URL, tagWithattributes);
		}
		else if(searchEngine.equals("yahoo")){
			/*webSearchEngine= new SearchEngineCrawler();
			return webSearchEngine.getBingResult(URL, tag, attribute,attributeName);*/
			//return "Testing";
			Map<String, Map<String, String>> tagWithattributes=new LinkedHashMap<String,Map<String,String>>();
			Map<String, String> attributes1=new LinkedHashMap<String, String>();
			attributes1.put("class","txt");
			String tag1 = new String("p");
			tagWithattributes.put(tag1,attributes1);
			Map<String, String> attributes2=new LinkedHashMap<String, String>();
			attributes2.put("class","subTxt");
			String tag2 = new String("p ");
			tagWithattributes.put(tag2, attributes2);
			return webSearchEngine.getBingResultContent(URL, tagWithattributes);
		}
		else if(searchEngine.equals("duckduckgo")){
		/*	webSearchEngine= new SearchEngineCrawler();
			return webSearchEngine.getBingResult(URL, tag, attribute,attributeName);*/
			//return "Testing";
			Map<String, Map<String, String>> tagWithattributes=new LinkedHashMap<String,Map<String,String>>();
			Map<String, String> attributes1=new LinkedHashMap<String, String>();
			attributes1.put("class","js-about-module-title module__title  ");
			String tag1 = new String("div");
			tagWithattributes.put(tag1,attributes1);
			Map<String, String> attributes2=new LinkedHashMap<String, String>();
			attributes2.put("class","module__text js-about-module-ellipsis");
			String tag2 = new String("div ");
			tagWithattributes.put(tag2, attributes2);
			return webSearchEngine.getBingResultContent(URL, tagWithattributes);
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
