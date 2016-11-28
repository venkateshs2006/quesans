package com.spring.quesans.crawler;

public class WikipediaSearch {
	private WebCrawler webCrawler;
	private static String tag;
	private static String attribute;
	private static String className;
	private static int tagPosition = 0;

	public static void setConfig(int pattern) {
		if (pattern == 2) {
			tag = "p";
			tagPosition = 1;
		}
		if (pattern == 1) {
			tag = "table";
			attribute = "class";
			className = "infobox biography vcard";
		}

	}

	public String getWikipediaResult(String URL, String tag, int tagPosition) {
		try {
			webCrawler = new WebCrawler();
			String divResultContent = webCrawler.getContentByAttribute(URL, tag, tagPosition);
			return divResultContent;
		} catch (Exception e) {
			System.out.println("Error while fetching Wiki content" + e.getMessage());
			return "Error";
		}
	}

	public String getWikipediaResult(String URL, String tag, String attribute, String className) {
		try {
			webCrawler = new WebCrawler();
			String divResultContent = webCrawler.getContentByAttribute(URL, tag, attribute, className);
			return divResultContent;
		} catch (Exception e) {
			System.out.println("Error while fetching Wiki content" + e.getMessage());
			return "Error";
		}
	}

	public String getFinalWikipediaResult(String URL) {
		String output = "";
		for (int pattern = 1; pattern <= 2; pattern++) {
			if (pattern == 1) {
				WikipediaSearch.setConfig(pattern);
				output = getWikipediaResult(URL, tag, attribute, className);
				
			} else if (pattern == 2) {
				WikipediaSearch.setConfig(pattern);
				output = getWikipediaResult(URL, tag, tagPosition);
			}
			if (!output.equals("Error")) {
				break;
			}
		}
		return output;
	}
}
