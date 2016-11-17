package com.spring.quesans.crawler;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class SearchEngineCrawler {
	private WebCrawler webCrawler;

	public String getGoogleResult(String URL, String tag, String attribute, String className) {
		try {
			webCrawler = new WebCrawler();
			String pageContent = webCrawler.getPageContent(URL);
			/*
			 * File googlePage = new File("googlePage.html");
			 * FileUtils.writeStringToFile(googlePage,pageContent);
			 */
			String divResultContent = webCrawler.getContentByAttribute(URL, tag, attribute, className);
			return divResultContent;
		} catch (Exception e) {
			System.out.println("Error while fetching Google content" + e.getMessage());
			System.out.println("Page Crawling is failed. Please contact administrator");
			return "Error Page";
		}
	}

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

	public String getYahooResult(String URL, String tag, String attribute, String className) {
		try {
			webCrawler = new WebCrawler();
			String divResultContent = webCrawler.getContentByAttribute(URL, tag, attribute, className);
			return divResultContent;
		} catch (Exception e) {
			System.out.println("Error while fetching Bing content" + e.getMessage());
			return "Page Crawling is failed. Please contact administrator";
		}
	}

	public String getDuckDuckGoResult(String URL, String tag, String attribute, String className) {
		try {
			webCrawler = new WebCrawler();
			String divResultContent = webCrawler.getContentByAttribute(URL, tag, attribute, className);
			return divResultContent;
		} catch (Exception e) {
			System.out.println("Error while fetching Bing content" + e.getMessage());
			return "Page Crawling is failed. Please contact administrator";
		}
	}

	public String getSearchContent(String URL, String tag, Map<String, String> attributes) {
		try {
			webCrawler = new WebCrawler();
			String divResultContent = webCrawler.getContentByAttributes(URL, tag, attributes);
			return divResultContent;
		} catch (Exception e) {
			return "Output";
		}
	}

	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		try {
			SearchEngineCrawler webSearchEngine = new SearchEngineCrawler();
			/*
			 * File google = new File("google.html"); File wiki = new
			 * File("wiki.html"); File bing = new File("bing.html"); File yahoo
			 * = new File("yahoo.html"); File duck = new File("duck.html");
			 * FileUtils.writeStringToFile(google,
			 * webSearchEngine.getGoogleResult(
			 * "http://www.google.co.in/search?q=Who+is+father+Of+google",
			 * "div", "class", "_OKe")); System.out.println("Google Completed");
			 * FileUtils.writeStringToFile(wiki,
			 * webSearchEngine.getWikipediaResult(
			 * "https://en.wikipedia.org/w/index.php?search=larry_page", "span",
			 * "class", "fn")); System.out.println("Wikipage Completed");
			 * FileUtils.writeStringToFile(bing, webSearchEngine.getBingResult(
			 * "http://www.bing.com/search?q=larry_page", "div", "class",
			 * "b_entityTP")); System.out.println("Bing Completed");
			 * FileUtils.writeStringToFile(yahoo, webSearchEngine
			 * .getYahooResult("http://search.yahoo.com/search?p=larry_page",
			 * "div", "class", "right")); FileUtils.writeStringToFile(duck,
			 * webSearchEngine.getDuckDuckGoResult(
			 * "http://duckduckgo.com/?q=larry_page", "div", "class",
			 * "js-sidebar-modules"));
			 * System.out.println("DuckDuckGo Completed");
			 */
			Map<String, String> htmlAttributes = new LinkedHashMap<String, String>();
			File google = new File("google.html");
			File google2A = new File("googlewithTwoAttribute.html");
			htmlAttributes.put("class", "_Q1n");
			htmlAttributes.put("role", "heading");
			FileUtils.writeStringToFile(google, webSearchEngine
					.getSearchContent("http://www.google.co.in/search?q=larry+page", "div", htmlAttributes));
			FileUtils.writeStringToFile(google2A, webSearchEngine
					.getGoogleResult("http://www.google.co.in/search?q=larry+page", "div", "class", "_OKe"));

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
	}
}