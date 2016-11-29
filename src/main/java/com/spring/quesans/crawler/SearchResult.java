package com.spring.quesans.crawler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchResult {
	private static final Pattern REMOVE_SCRIPT_TAGS = Pattern.compile("<script>[\\w\\W]*</script>");
	private static final Pattern REMOVE_TAGS = Pattern.compile("<.+?>");
	private static final Pattern REMOVE_CDATA_TAGS=Pattern.compile("<[^>]*>\\s*");
	private GoogleSearch googleSearch;
	private WikipediaSearch wikipediaSearch;
    private BingSearch bingSearch;
	public String getResult(String searchEngine, String URL) {
		System.out.println("Search Result Class :" + searchEngine + " :" + URL);
		if (searchEngine.equals("google")) {
			googleSearch = new GoogleSearch();
			return removeTags(googleSearch.getFinalGoogleSearchResult(URL));
		} else if (searchEngine.equals("wikipedia")) {
			wikipediaSearch = new WikipediaSearch();
			return removeTags(wikipediaSearch.getFinalWikipediaResult(URL));
		} else if (searchEngine.equals("bing")) {
			bingSearch=new BingSearch();
			return removeTags(bingSearch.getFinalBingResultContent(URL));
		} else if (searchEngine.equals("yahoo")) {
			return "Error";
		} else if (searchEngine.equals("duckduckgo")) {
			return "Error";
		} else {
			return "Error";
		}		
	}
	public static String removeTags(String string) {
		System.out.println("Input String :"+ string);
	    if (string == null || string.length() == 0) {
	        return string;
	    }
	    Matcher m = REMOVE_SCRIPT_TAGS.matcher(string);
	    String afterScriptTag=m.replaceAll("");
	    Matcher m1 = REMOVE_CDATA_TAGS.matcher(afterScriptTag);
	    String afterCdataTag=m1.replaceAll("");
	    Matcher m2 = REMOVE_TAGS.matcher(afterCdataTag);
	    return (m2.replaceAll(""));
	}
}
