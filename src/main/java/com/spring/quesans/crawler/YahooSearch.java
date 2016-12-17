package com.spring.quesans.crawler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class YahooSearch {
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
			tag = "span";
			attribute = "class";
			className = " lh-l";
		}

		if(pattern==4){
			tagWithattributes=new LinkedHashMap<String,Map<String,String>>();
			attributes1=new LinkedHashMap<String, String>();
			attributes1.put("class","txt");
			String tag1 = new String("p");
			tagWithattributes.put(tag1,attributes1);
			attributes2=new LinkedHashMap<String, String>();
			attributes2.put("class","subTxt");
			String tag2 = new String("p ");
			tagWithattributes.put(tag2, attributes2);
			System.out.println(tagWithattributes.toString());
		}
			
		if (pattern == 2) {
			tag = "div";
			attribute="class";
			className="cptn-ctnt";
		}
		if(pattern==3){
			tag = "div";
			attribute = "class";
			className = "compText mb-15";
		}

	}

	public String getYahooResult(String URL, String tag, String attribute, String className) {
		try {
			webCrawler = new WebCrawler();
			String divResultContent = webCrawler.getContentByAttribute(URL, tag, attribute, className);
			return divResultContent;
		} catch (Exception e) {
			System.out.println("Error while fetching Bing content" + e.getMessage());
			return "Error";
		}
	}
	public String getYahooResultContent(String URL, Map<String, Map<String, String>> tagWithattributes) {
		webCrawler = new WebCrawler();
		List<String> results = webCrawler.getContentFromMorethanoneTag(URL, tagWithattributes);
		return results == null ? "Error" : results.toString();
	}
	public String getFinalDuckResultContent(String URL) {
		String output = "";

		for (int pattern = 1; pattern <= 4; pattern++) {
			if (pattern == 1) {
				BingSearch.setConfig(pattern);
				output = getYahooResult(URL, tag, attribute, className);
				
			} else if (pattern == 2) {
				BingSearch.setConfig(pattern);
				output = getYahooResult(URL, tag, attribute, className);
			}  
			 else if (pattern == 3) {
					BingSearch.setConfig(pattern);
					output = getYahooResult(URL, tag, attribute, className);
				}  
			else if (pattern == 4) {
				BingSearch.setConfig(pattern);
				output = getYahooResultContent(URL, tagWithattributes);
			} 
			System.out.println("Loop :"+pattern+"  : "+output);
			if (!output.equals("Error")) {
				break;
			}
		}
		return output;
	}

	

}
