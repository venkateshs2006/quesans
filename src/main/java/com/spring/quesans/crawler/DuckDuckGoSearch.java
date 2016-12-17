package com.spring.quesans.crawler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DuckDuckGoSearch {
	private WebCrawler webCrawler;
	private static String tag;
	private static String attribute;
	private static String className;
	private static Map<String, String> attributes2;
	private static Map<String, String> attributes1;
	private static Map<String, Map<String, String>> tagWithattributes;
	private static Map<String, String> attributes;

	public static void setConfig(int pattern) {
		if (pattern == 1) {
			tag = "div";
			attribute = "class";
			className = "module__content";
		}

		if (pattern == 2) {
			tagWithattributes = new LinkedHashMap<String, Map<String, String>>();
			attributes1 = new LinkedHashMap<String, String>();
			attributes1.put("class", "js-about-module-title module__title  ");
			String tag1 = new String("div");
			tagWithattributes.put(tag1, attributes1);
			Map<String, String> attributes2 = new LinkedHashMap<String, String>();
			attributes2.put("class", "module__text js-about-module-ellipsis");
			String tag2 = new String("div ");
			tagWithattributes.put(tag2, attributes2);
			System.out.println(tagWithattributes.toString());
		}

		/*
		 * if (pattern == 1) { tag = "li"; attributes = new
		 * LinkedHashMap<String, String>(); attributes.put("class",
		 * "b_ans b_top b_topborder"); //attributes.put("data-bm", "8"); }
		 * if(pattern==4){ tag = "span"; attribute = "class"; className =
		 * "b_slyGridItem"; }
		 */

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

	public String getDuckResultContent(String URL, Map<String, Map<String, String>> tagWithattributes) {
		webCrawler = new WebCrawler();
		List<String> results = webCrawler.getContentFromMorethanoneTag(URL, tagWithattributes);
		return results == null ? "Error" : results.toString();
	}

	public String getFinalDuckResultContent(String URL) {
		String output = "";

		for (int pattern = 1; pattern <= 2; pattern++) {
			if (pattern == 1) {
				DuckDuckGoSearch.setConfig(pattern);
				output = getDuckDuckGoResult(URL, tag, attribute, className);

			} else if (pattern == 2) {
				DuckDuckGoSearch.setConfig(pattern);
				output = getDuckResultContent(URL, tagWithattributes);
			}
			System.out.println("Loop :" + pattern + "  : " + output);
			if (!output.equals("Error")) {
				break;
			}
		}
		return output;
	}

}
