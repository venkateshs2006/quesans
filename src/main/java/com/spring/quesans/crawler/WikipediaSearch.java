package com.spring.quesans.crawler;

public class WikipediaSearch {
	private WebCrawler webCrawler;
	public String getWikipediaResult(String URL, String tag, String attribute, String className) {
		try {
			webCrawler = new WebCrawler();
			String divResultContent = webCrawler.getContentByAttribute(URL, tag, attribute, className);
			return divResultContent;
		} catch (Exception e) {
			System.out.println("Error while fetching Wiki content" + e.getMessage());
			return "Page Crawling is failed. Please contact administrator";
		}
	}
}
