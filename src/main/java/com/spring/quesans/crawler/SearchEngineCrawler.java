package com.spring.quesans.crawler;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
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

	public String getBingResultContent(String URL, Map<String, Map<String, String>> tagWithattributes) {
		webCrawler = new WebCrawler();
		List<String> results = webCrawler.getContentFromMorethanoneTag(URL, tagWithattributes);
		return results == null ? "Error" : results.toString();
	}
	public String getYahooResultContent(String URL, Map<String, Map<String, String>> tagWithattributes) {
		webCrawler = new WebCrawler();
		List<String> results = webCrawler.getContentFromMorethanoneTag(URL, tagWithattributes);
		return results == null ? "Error" : results.toString();
	}
	public String getDuckResultContent(String URL, Map<String, Map<String, String>> tagWithattributes) {
		webCrawler = new WebCrawler();
		List<String> results = webCrawler.getContentFromMorethanoneTag(URL, tagWithattributes);
		return results == null ? "Error" : results.toString();
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
			/*Map<String, String> htmlAttributes = new LinkedHashMap<String, String>();
			File google = new File("google.html");
			File bing = new File("bing.html");
			File google2A = new File("googlewithTwoAttribute.html");
			htmlAttributes.put("class", "_Q1n");
			htmlAttributes.put("role", "heading");
			FileUtils.writeStringToFile(google, webSearchEngine
					.getSearchContent("http://www.google.co.in/search?q=larry+page", "div", htmlAttributes));
			FileUtils.writeStringToFile(google2A, webSearchEngine
					.getGoogleResult("http://www.google.co.in/search?q=larry+page", "div", "class", "_OKe"));
			FileUtils.writeStringToFile(google2A, webSearchEngine
					.getGoogleResult("http://www.google.co.in/search?q=larry+page", "div", "class", "_OKe"));*/
/*			File bing = new File("bing.html");
			Map<String, Map<String, String>> tagWithattributes=new LinkedHashMap<String,Map<String,String>>();
			Map<String, String> attributes1=new LinkedHashMap<String, String>();
			attributes1.put("class"," b_entityTitle");
			tagWithattributes.put("h2",attributes1);
			Map<String, String> attributes2=new LinkedHashMap<String, String>();
			attributes2.put("class","b_entitySubTitle");
			tagWithattributes.put("div", attributes2);
			System.out.println(tagWithattributes.toString());
			FileUtils.writeStringToFile(bing, webSearchEngine.getBingResultContent("http://www.bing.com/search?q=larry_page", tagWithattributes)); 
			System.out.println("Bing Completed");
			File yahoo = new File("yahoo.html");
			Map<String, Map<String, String>> tagWithattributes1=new LinkedHashMap<String,Map<String,String>>();
			Map<String, String> attributes11=new LinkedHashMap<String, String>();
			attributes11.put("class","txt");
			String tag1 = new String("p");
			tagWithattributes1.put(tag1,attributes11);
			Map<String, String> attributes12=new LinkedHashMap<String, String>();
			attributes12.put("class","subTxt");
			String tag2 = new String("p ");
			tagWithattributes1.put(tag2, attributes12);
			System.out.println(tagWithattributes1.toString());
			FileUtils.writeStringToFile(yahoo, webSearchEngine.getYahooResultContent("http://search.yahoo.com/search?p=larry_page",tagWithattributes1));
			System.out.println("Yahoo Completed");*/
			Map<String, Map<String, String>> tagWithattributes2=new LinkedHashMap<String,Map<String,String>>();
			Map<String, String> attributes21=new LinkedHashMap<String, String>();
			attributes21.put("class","js-about-module-title module__title  ");
			String tag21 = new String("div");
			tagWithattributes2.put(tag21,attributes21);
			Map<String, String> attributes22=new LinkedHashMap<String, String>();
			attributes22.put("class","module__text js-about-module-ellipsis");
			String tag22 = new String("div ");
			tagWithattributes2.put(tag22, attributes22);		
			
			System.out.println(tagWithattributes2.toString());
			File duck = new File("duck.html");
			FileUtils.writeStringToFile(duck,webSearchEngine.getDuckResultContent("http://duckduckgo.com/?q=larry+page",tagWithattributes2));
			System.out.println("Duck Completed");
		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
	}
}