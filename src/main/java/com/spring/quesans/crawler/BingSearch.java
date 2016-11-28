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

	public static void setConfig(int pattern) {
		if (pattern == 2) {
			tag = "div";
			attribute = "class";
			className = "b_entityTP";
		}
		if (pattern == 1) {
			tagWithattributes = new LinkedHashMap<String, Map<String, String>>();
			attributes1 = new LinkedHashMap<String, String>();
			attributes1.put("class", " b_entityTitle");
			tagWithattributes.put("h2", attributes1);
			attributes2 = new LinkedHashMap<String, String>();
			attributes2.put("class", "b_entitySubTitle");
			tagWithattributes.put("div", attributes2);
			System.out.println(tagWithattributes.toString());
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

	public String getBingResultContent(String URL, Map<String, Map<String, String>> tagWithattributes) {
		webCrawler = new WebCrawler();
		List<String> results = webCrawler.getContentFromMorethanoneTag(URL, tagWithattributes);
		return results == null ? "Error" : results.toString();
	}

	public String getFinalBingResultContent(String URL) {
		String output = "";

		for (int pattern = 1; pattern <= 2; pattern++) {
			if (pattern == 1) {
				BingSearch.setConfig(pattern);
				output = getBingResultContent(URL, tagWithattributes);
			} else if (pattern == 2) {
				BingSearch.setConfig(pattern);
				output = getBingResultContent(URL, tag, attribute, className);
			}
			if (!output.equals("Error")) {
				break;
			}
		}
		return output;
	}
}
