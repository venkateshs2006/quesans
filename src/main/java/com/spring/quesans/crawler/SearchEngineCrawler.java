package com.spring.quesans.crawler;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class SearchEngineCrawler {
	private WebCrawler webCrawler;
	public String getGoogleResult(String URL, String tag, String className) {
		try {
			webCrawler = new WebCrawler();
			String divResultContent = webCrawler.getContentByClass(URL, tag, className);
			return divResultContent;
		} catch (Exception e) {
			System.out.println("Error while fetching Google content" + e.getMessage());
			return "Page Crawling is failed. Please contact administrator";
		}
	}

	public String getWikipediaResult(String URL, String tag, String className) {
		try {
			webCrawler = new WebCrawler();
			String divResultContent = webCrawler.getContentByClass(URL, tag, className);
			return divResultContent;
		} catch (Exception e) {
			System.out.println("Error while fetching Wiki content" + e.getMessage());
			return "Page Crawling is failed. Please contact administrator";
		}
	}

	public String getBingResult(String URL, String tag, String className) {
		try {
			webCrawler = new WebCrawler();
			String divResultContent = webCrawler.getContentByClass(URL, tag, className);
			return divResultContent;
		} catch (Exception e) {
			System.out.println("Error while fetching Bing content" + e.getMessage());
			return "Page Crawling is failed. Please contact administrator";
		}
	}

	public String getYahooResult(String URL, String tag, String elementId) {
		try {
			webCrawler = new WebCrawler();
			String divResultContent = webCrawler.getContentByTagId(URL, tag, elementId);
			return divResultContent;
		} catch (Exception e) {
			System.out.println("Error while fetching Bing content" + e.getMessage());
			return "Page Crawling is failed. Please contact administrator";
		}
	}
	public String getDuckDuckGoResult(String URL, String tag, String className) {
		try {
			webCrawler = new WebCrawler();
			String divResultContent = webCrawler.getContentByClass(URL, tag, className);
			return divResultContent;
		} catch (Exception e) {
			System.out.println("Error while fetching Bing content" + e.getMessage());
			return "Page Crawling is failed. Please contact administrator";
		}
	}
	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		try {
			SearchEngineCrawler webSearchEngine = new SearchEngineCrawler();
			File google = new File("google.html");
			File wiki = new File("wiki.html");
			File bing = new File("bing.html");
			File yahoo = new File("yahoo.html");
			File duck=new File("duck.html");
			FileUtils.writeStringToFile(google,
					webSearchEngine.getGoogleResult("http://www.google.co.in/search?q=Father of Facebook", "div", "_RBg"));
			System.out.println("Google Completed");
			FileUtils.writeStringToFile(wiki, webSearchEngine.getWikipediaResult("http://en.wikipedia.org/wiki/Larry_Page",
					"div", "mw-body-content"));
			System.out.println("Wikipage Completed");
			FileUtils.writeStringToFile(bing,
					webSearchEngine.getBingResult("http://www.bing.com/search?q=larry+page", "div", "b_entityTP"));
			System.out.println("Bing Completed");
			FileUtils.writeStringToFile(yahoo,
					webSearchEngine.getYahooResult("http://search.yahoo.com/search?p=Mark+Zuckerberg", "div", "right"));
			FileUtils.writeStringToFile(duck,
					webSearchEngine.getDuckDuckGoResult("http://duckduckgo.com/?q=larry+page", "div", "js-sidebar-modules"));
			System.out.println("DuckDuckGo Completed");
		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
	}
}