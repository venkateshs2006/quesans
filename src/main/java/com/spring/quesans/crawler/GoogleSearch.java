package com.spring.quesans.crawler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GoogleSearch {
	private WebCrawler webCrawler;
	private static String tag;
	private static String attribute;
	private static String className;
	private static Map<String, String> attributes;
	private static Map<String, Map<String, String>> tagWithattributes;
	private static Map<String, String> attributes1;
	private static Map<String, String> attributes2;
	public static void setConfig(int pattern) {
		if (pattern == 1) {
			tag = "div";
			attribute = "class";
			className = "rl_container";
		}
		/*if (pattern == 1) {
			tagWithattributes = new LinkedHashMap<String, Map<String, String>>();
			attributes1 = new LinkedHashMap<String, String>();
			attributes1.put("class", "_Mjf");
			tagWithattributes.put("div", attributes1);
			attributes2 = new LinkedHashMap<String, String>();
			attributes2.put("class", "_Mjf");
			tagWithattributes.put(" div", attributes2);
			System.out.println(tagWithattributes.toString());
		}
		if (pattern == 1) {
			tag = "div";
			attributes = new LinkedHashMap<String, String>();
			attributes.put("class", "rl_slider_container");
			attributes.put("data-ved", "0ahUKEwjK_6Pl38vQAhXMMY8KHQGnDeUQrS4IGDAb");
		}*/
		if (pattern == 2) {
			tag = "div";
			attribute = "class";
			className = "lr_container mod";
		}
		if (pattern == 3) {
			tag = "div";
			attribute = "class";
			className = "g _rk";
		}
		if (pattern == 4) {
			tag = "div";
			attribute = "class";
			className = "_XWk";
		}
		if (pattern == 5) {
			tag = "div";
			attributes = new LinkedHashMap<String, String>();
			attributes.put("class", "kp-header");
			attributes.put("data-ved", "0ahUKEwjh09mKjMHQAhXGM48KHRrDDeEQ3z4IHCgB");
		}
		if (pattern == 6) {
			tag = "div";
			attributes = new LinkedHashMap<String, String>();
			attributes.put("class", "mod");
			attributes.put("data-hveid", "33");
		}
		
		if (pattern == 7) {
			tag = "div";
			attributes = new LinkedHashMap<String, String>();
			attributes.put("class", "_Q1n");
			attributes.put("role", "heading");
		}
		if (pattern == 8) {
			tag = "div";
			attribute = "class";
			className = "_OKe";
		}

	}

	public String getGoogleSearchContent(String URL, String tag, String attribute, String className) {
		try {
			webCrawler = new WebCrawler();
			String divResultContent = webCrawler.getContentByAttribute(URL, tag, attribute, className);
			return divResultContent;
		} catch (Exception e) {
			System.out.println("Error while fetching Google content" + e.getMessage());
			return "Error";
		}
	}

	public String getGoogleSearchContent(String URL, String tag, Map<String, String> attributes) {
		try {
			webCrawler = new WebCrawler();
			String divResultContent = webCrawler.getContentByAttributes(URL, tag, attributes);
			return divResultContent;
		} catch (Exception e) {
			return "Error";
		}
	}

	public String getGoogleSearchContent(String URL, Map<String, Map<String, String>> tagWithattributes) {
		webCrawler = new WebCrawler();
		List<String> results = webCrawler.getContentFromMorethanoneTag(URL, tagWithattributes);
		return results == null ? "Error" : results.toString();
	}
	
	public String getFinalGoogleSearchResult(String URL) {
		String output = "";
		
		for (int pattern = 1; pattern <= 8; pattern++) {
			if (pattern == 1) {
				GoogleSearch.setConfig(pattern);
				output = getGoogleSearchContent(URL, tag, attribute, className);
			} else if (pattern == 2) {
				GoogleSearch.setConfig(pattern);
				output = getGoogleSearchContent(URL, tag, attribute, className);
			} else if (pattern == 3) {
				GoogleSearch.setConfig(pattern);
				output = getGoogleSearchContent(URL, tag, attribute, className);
				
			} else if (pattern == 4) {
				GoogleSearch.setConfig(pattern);
				output = getGoogleSearchContent(URL, tag, attribute, className);
				
			}else if (pattern == 5) {
				GoogleSearch.setConfig(pattern);
				output = getGoogleSearchContent(URL, tag, attributes);
			} else if (pattern == 6) {
				GoogleSearch.setConfig(pattern);
				output = getGoogleSearchContent(URL, tag, attributes);
			} else if (pattern == 7) {
				GoogleSearch.setConfig(pattern);
				output = getGoogleSearchContent(URL, tag, attributes);
			} else if (pattern == 8) {
				GoogleSearch.setConfig(pattern);
				output = getGoogleSearchContent(URL, tag, attribute, className);
			}
			if(!output.equals("Error")){
				break;
			}
		}
		return output;
	}
}

