package com.spring.quesans.crawler;

import java.util.List;
import java.util.Map;

public class BingSearch {
	private WebCrawler webCrawler;
	public String getBingResult(String URL, String tag, String attribute, String className) {
		try {
			webCrawler = new WebCrawler();
			String divResultContent = webCrawler.getContentByAttribute(URL, tag, attribute, className);
			return divResultContent;
		} catch (Exception e) {
			System.out.println("Error while fetching Bing content" + e.getMessage());
			return "Page Crawling is failed. Please contact administrator";
		}
	}
	public String getBingResultContent(String URL, Map<String, Map<String, String>> tagWithattributes) {
		webCrawler = new WebCrawler();
		List<String> results = webCrawler.getContentFromMorethanoneTag(URL, tagWithattributes);
		return results == null ? "Error" : results.toString();
	}
}
