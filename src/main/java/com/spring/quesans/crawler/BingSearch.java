package com.spring.quesans.crawler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BingSearch {
	private WebCrawler webCrawler;
	private static String tag;
	private static String attribute;
	private static String className;
	private static Map<String, String> attributes2;
	private static Map<String, String> attributes1;
	private static Map<String, Map<String, String>> tagWithattributes;
	private static Map<String, String> attributes;
	public static void setConfig(int pattern) {
		if (pattern == 3) {
			tag = "div";
			attribute = "class";
			className = "b_entityTP";
		}
		if (pattern == 2) {
			tagWithattributes = new LinkedHashMap<String, Map<String, String>>();
			attributes1 = new LinkedHashMap<String, String>();
			attributes1.put("class", " b_entityTitle");
			tagWithattributes.put("h2", attributes1);
			attributes2 = new LinkedHashMap<String, String>();
			attributes2.put("class", "b_entitySubTitle");
			tagWithattributes.put("div", attributes2);
			System.out.println(tagWithattributes.toString());
		}
		if (pattern == 1) {
			tag = "li";
			attributes = new LinkedHashMap<String, String>();
			attributes.put("class", "b_ans b_top b_topborder");
			//attributes.put("data-bm", "8");
		}

	}

	public String getBingResultContent(String URL, String tag, String attribute, String className) {
		try {
			webCrawler = new WebCrawler();
			String divResultContent = webCrawler.getContentByAttribute(URL, tag, attribute, className);
			return divResultContent;
		} catch (Exception e) {
			System.out.println("Error while fetching Bing content" + e.getMessage());
			return "Page Crawling is failed. Please contact administrator";
		}
	}
	public String getBingResultContent(String URL,String tag,  Map<String, String> attributes) {
		try {
		webCrawler = new WebCrawler();
		String results = webCrawler.getContentByAttributes(URL, tag, attributes);
		return results;
		}
		catch(Exception e){
		return "Error";
		}
	}
	public String getBingResultContent(String URL, Map<String, Map<String, String>> tagWithattributes) {
		webCrawler = new WebCrawler();
		List<String> results = webCrawler.getContentFromMorethanoneTag(URL, tagWithattributes);
		return results == null ? "Error" : results.toString();
	}

	public String getFinalBingResultContent(String URL) {
		String output = "";

		for (int pattern = 1; pattern <= 3; pattern++) {
			if (pattern == 1) {
				BingSearch.setConfig(pattern);
				output = getBingResultContent(URL, tag, attributes);
				
			} else if (pattern == 2) {
				BingSearch.setConfig(pattern);
				output = getBingResultContent(URL, tagWithattributes);
			}
			else if (pattern == 2) {
				BingSearch.setConfig(pattern);
				output = getBingResultContent(URL, tag, attribute, className);
			}
			System.out.println("Loop :"+pattern+"  : "+output);
			if (!output.equals("Error")) {
				break;
			}
		}
		return output;
	}
}
