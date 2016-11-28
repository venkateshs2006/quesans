package com.spring.quesans.crawler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchResult {
	private static final Pattern REMOVE_SCRIPT_TAGS = Pattern.compile("<script>[^>]*?</script>");
	private static final Pattern REMOVE_TAGS = Pattern.compile("<.+?>");
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
		/*
		 * else if(searchEngine.equals("wikipedia")){ webSearchEngine= new
		 * SearchEngineCrawler(); return webSearchEngine.getWikipediaResult(URL,
		 * tag,attribute, attributeName); } else
		 * if(searchEngine.equals("bing")){ webSearchEngine= new
		 * SearchEngineCrawler(); return webSearchEngine.getBingResult(URL, tag,
		 * attribute,attributeName); webSearchEngine= new SearchEngineCrawler();
		 * Map<String, Map<String, String>> tagWithattributes=new
		 * LinkedHashMap<String,Map<String,String>>(); Map<String, String>
		 * attributes1=new LinkedHashMap<String, String>();
		 * attributes1.put("class"," b_entityTitle");
		 * tagWithattributes.put("h2",attributes1); Map<String, String>
		 * attributes2=new LinkedHashMap<String, String>();
		 * attributes2.put("class","b_entitySubTitle");
		 * tagWithattributes.put("div", attributes2); return
		 * webSearchEngine.getBingResultContent(URL, tagWithattributes); } else
		 * if(searchEngine.equals("yahoo")){ webSearchEngine= new
		 * SearchEngineCrawler(); return webSearchEngine.getBingResult(URL, tag,
		 * attribute,attributeName); //return "Testing"; Map<String, Map<String,
		 * String>> tagWithattributes=new
		 * LinkedHashMap<String,Map<String,String>>(); Map<String, String>
		 * attributes1=new LinkedHashMap<String, String>();
		 * attributes1.put("class","txt"); String tag1 = new String("p");
		 * tagWithattributes.put(tag1,attributes1); Map<String, String>
		 * attributes2=new LinkedHashMap<String, String>();
		 * attributes2.put("class","subTxt"); String tag2 = new String("p ");
		 * tagWithattributes.put(tag2, attributes2); return
		 * webSearchEngine.getBingResultContent(URL, tagWithattributes); } else
		 * if(searchEngine.equals("duckduckgo")){ webSearchEngine= new
		 * SearchEngineCrawler(); return webSearchEngine.getBingResult(URL, tag,
		 * attribute,attributeName); //return "Testing"; Map<String, Map<String,
		 * String>> tagWithattributes=new
		 * LinkedHashMap<String,Map<String,String>>(); Map<String, String>
		 * attributes1=new LinkedHashMap<String, String>();
		 * attributes1.put("class","js-about-module-title module__title  ");
		 * String tag1 = new String("div");
		 * tagWithattributes.put(tag1,attributes1); Map<String, String>
		 * attributes2=new LinkedHashMap<String, String>();
		 * attributes2.put("class","module__text"); String tag2 = new
		 * String("div "); tagWithattributes.put(tag2, attributes2); return
		 * webSearchEngine.getBingResultContent(URL, tagWithattributes); } else{
		 * return "Search Engine Not configured"; } } public String
		 * getResult(String searchEngine, String URL,String tag,Map<String,
		 * String> attributes){
		 * System.out.println("Search Result Class :"+searchEngine+" :"
		 * +URL+"  :"+tag+"  :"+attributes.toString());
		 * if(searchEngine.equals("google")){ webSearchEngine= new
		 * SearchEngineCrawler(); return
		 * webSearchEngine.getGoogleSearchContent(URL, tag,attributes); //return
		 * "Testing"; } else{ return "Search Engine Not configured"; } } public
		 * String getResult(String searchEngine, String URL){
		 * System.out.println("Search Result Class :"+searchEngine+" :"+URL);
		 * if(searchEngine.equals("google")){ webSearchEngine= new
		 * SearchEngineCrawler(); return
		 * webSearchEngine.getGoogleSearchContent(URL); } else
		 * if(searchEngine.equals("wikipedia")){ webSearchEngine= new
		 * SearchEngineCrawler(); return
		 * webSearchEngine.getWikipediaResult(URL,"","",""); } else
		 * if(searchEngine.equals("bing")){ webSearchEngine= new
		 * SearchEngineCrawler(); return webSearchEngine.getBingResult(URL, tag,
		 * attribute,attributeName); webSearchEngine= new SearchEngineCrawler();
		 * Map<String, Map<String, String>> tagWithattributes=new
		 * LinkedHashMap<String,Map<String,String>>(); Map<String, String>
		 * attributes1=new LinkedHashMap<String, String>();
		 * attributes1.put("class"," b_entityTitle");
		 * tagWithattributes.put("h2",attributes1); Map<String, String>
		 * attributes2=new LinkedHashMap<String, String>();
		 * attributes2.put("class","b_entitySubTitle");
		 * tagWithattributes.put("div", attributes2); return
		 * webSearchEngine.getBingResultContent(URL, tagWithattributes); } else
		 * if(searchEngine.equals("yahoo")){ webSearchEngine= new
		 * SearchEngineCrawler(); return webSearchEngine.getBingResult(URL, tag,
		 * attribute,attributeName); //return "Testing"; Map<String, Map<String,
		 * String>> tagWithattributes=new
		 * LinkedHashMap<String,Map<String,String>>(); Map<String, String>
		 * attributes1=new LinkedHashMap<String, String>();
		 * attributes1.put("class","txt"); String tag1 = new String("p");
		 * tagWithattributes.put(tag1,attributes1); Map<String, String>
		 * attributes2=new LinkedHashMap<String, String>();
		 * attributes2.put("class","subTxt"); String tag2 = new String("p ");
		 * tagWithattributes.put(tag2, attributes2); return
		 * webSearchEngine.getBingResultContent(URL, tagWithattributes); } else
		 * if(searchEngine.equals("duckduckgo")){ webSearchEngine= new
		 * SearchEngineCrawler(); return webSearchEngine.getBingResult(URL, tag,
		 * attribute,attributeName); //return "Testing"; Map<String, Map<String,
		 * String>> tagWithattributes=new
		 * LinkedHashMap<String,Map<String,String>>(); Map<String, String>
		 * attributes1=new LinkedHashMap<String, String>();
		 * attributes1.put("class","js-about-module-title module__title  ");
		 * String tag1 = new String("div");
		 * tagWithattributes.put(tag1,attributes1); Map<String, String>
		 * attributes2=new LinkedHashMap<String, String>();
		 * attributes2.put("class","module__text js-about-module-ellipsis");
		 * String tag2 = new String("div "); tagWithattributes.put(tag2,
		 * attributes2); return webSearchEngine.getBingResultContent(URL,
		 * tagWithattributes); } else{ return "Search Engine Not configured"; }
		 * } public String getResult(String searchEngine, String URL,Map<String,
		 * Map<String, String>> tagWithAttributes){
		 * System.out.println("Search Result Class :"+searchEngine+" :"
		 * +URL+"  :"+tagWithAttributes.toString());
		 * if(searchEngine.equals("google")){ return null; } else{ return null;
		 * } }
		 */
	}

	public static String removeTags(String string) {
	    if (string == null || string.length() == 0) {
	        return string;
	    }
	    Matcher m = REMOVE_SCRIPT_TAGS.matcher(string);
	    String afterScriptTag=m.replaceAll("");
	    Matcher m1 = REMOVE_TAGS.matcher(afterScriptTag);
	    return (m1.replaceAll(""));
	}
}
