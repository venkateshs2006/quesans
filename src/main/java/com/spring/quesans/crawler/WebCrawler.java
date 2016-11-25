package com.spring.quesans.crawler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlHeading2;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;
import com.gargoylesoftware.htmlunit.html.HtmlHeading4;
import com.gargoylesoftware.htmlunit.html.HtmlHeading5;
import com.gargoylesoftware.htmlunit.html.HtmlHeading6;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlParagraph;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;

public class WebCrawler {
	private static final String PROXY_HOST = "campus-proxy";
	private static final int PROXY_PORT = 8080;
	private static final String USERNAME = "venkatesh.sa";
	private static final String PASSWORD = "Sv25081985";
	private static final String DOMAIN = "HCLTECH";

	public static WebClient getProxyWebConnection() {
		@SuppressWarnings("deprecation")
		WebClient webClient = new WebClient(BrowserVersion.FIREFOX_38, PROXY_HOST, PROXY_PORT);
		DefaultCredentialsProvider cp = (DefaultCredentialsProvider) webClient.getCredentialsProvider();
		cp.addNTLMCredentials(USERNAME, PASSWORD, PROXY_HOST, PROXY_PORT, null, DOMAIN);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		return webClient;
	}

	public static WebClient getWebConnection() {
		@SuppressWarnings("deprecation")
		WebClient webClient = new WebClient(BrowserVersion.FIREFOX_38);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		return webClient;
	}

	public String getPageContent(String URL) {
		WebClient webClient = WebCrawler.getProxyWebConnection();
		HtmlPage currentPage;
		try {
			currentPage = webClient.getPage(URL);
			WebResponse response = currentPage.getWebResponse();
			String content = response.getContentAsString();
			return content;
		} catch (FailingHttpStatusCodeException | IOException e) {
			System.out.println("Content based Exception occured" + e.getMessage());
			return "Page Crawling is Failed. Please Contact Administrator";
		}
	}

	public String getContentById(String URL, String elementId) throws Exception {
		try {
			WebClient webClient = WebCrawler.getProxyWebConnection();
			HtmlPage page = webClient.getPage(URL);
			HtmlDivision div = page.getHtmlElementById(elementId);
			return div.getTextContent();
		} catch (Exception e) {
			System.out.println("Element based Exception occured" + e.getMessage());
			return "Page Crawling is Failed. Please Contact Administrator";
		}
	}

	public String getContentByClass(String URL, String tag, String className) throws Exception {
		try {
			WebClient webClient = WebCrawler.getProxyWebConnection();
			HtmlPage page = webClient.getPage(URL);
			if (tag.equals("div")) {
				HtmlDivision div = (HtmlDivision) page.getByXPath("//" + tag + "[@class='" + className + "']").get(0);
				return div.asXml();
			} else if (tag.equals("span")) {
				HtmlSpan span = (HtmlSpan) page.getByXPath("//" + tag + "[@class='" + className + "']").get(0);
				return span.asXml();
			} else {
				return "Error";
			}

		} catch (Exception e) {
			System.out.println("Class based exception occured" + e.getMessage());
			return "Exception Error";
		}
	}

	public String getContentByAttribute(String URL, String tag, String attribute, String attributeName)
			throws Exception {
		try {
			System.out.println("Input values :" + URL + "   :" + tag + "  :" + attribute + "  :" + attributeName);
			WebClient webClient = WebCrawler.getProxyWebConnection();
			HtmlPage page = webClient.getPage(URL);
			return extractTagContent(page, tag, attribute, attributeName);

		} catch (Exception e) {
			System.out.println("Class based exception occured" + e.getMessage());
			return "Exception Error";
		}
	}

	public String getContentByAttributes(String URL, String tag, Map<String, String> attributes) throws Exception {
		try {
			// System.out.println("Input values :"+URL+" :"+tag+" :"+attribute+"
			// :"+attributeName);
			String checkingCondition = buildCondition(attributes);
			System.out.println("Checking Condition :" + "//" + tag + "[" + checkingCondition + "]");
			WebClient webClient = WebCrawler.getProxyWebConnection();
			HtmlPage page = webClient.getPage(URL);
			File googlePage = new File("googlePage.html");
			FileUtils.writeStringToFile(googlePage, page.asXml());			
			return extractTagContent(page, tag, checkingCondition);
		} catch (Exception e) {
			System.out.println("Class based exception occured" + e.getMessage());
			return "Exception Error";
		}
	}

	public String getContentByTagId(String URL, String tag, String elementId) throws Exception {
		try {
			WebClient webClient = WebCrawler.getProxyWebConnection();
			HtmlPage page = webClient.getPage(URL);
			HtmlDivision div = (HtmlDivision) page.getByXPath("//" + tag + "[@id='" + elementId + "']").get(0);
			return div.asXml(); 
		} catch (Exception e) {
			System.out.println("Class based exception occured" + e.getMessage());
			return "Page Crawling is Failed. Please Contact Administrator";
		}
	}

	public List<String> getContentFromMorethanoneTag(String URL, Map<String, Map<String, String>> tagWithAttributes) {
		List<String> results = new ArrayList<String>();
		Map<String, Map<String, String>> tagWithArributes = tagWithAttributes;
		try {
			WebClient webClient = WebCrawler.getProxyWebConnection();
			HtmlPage page = webClient.getPage(URL);
			for (String s : tagWithArributes.keySet()) {
				Map<String, String> attributes = tagWithArributes.get(s);
				String checkingCondition = buildCondition(attributes);
				System.out.println("Checking Condition :"+checkingCondition);
				String result = extractTagContent(page, s.trim(), checkingCondition);
				results.add(result);
			}
		} catch (Exception e) {
			System.out.println("Class based exception occured" + e.getMessage());
			return null;
		}
		return results;
	}

	public String buildCondition(Map<String, String> attributes) {
		Map<String, String> htmlAttributes = attributes;
		Set<String> htmlKeySet = attributes.keySet();
		int position = 0;
		String checkingCondition = "";
		for (String keySet : htmlKeySet) {
			if (position == 0) {
				checkingCondition = "@" + keySet + " ='" + htmlAttributes.get(keySet) + "'";
				position++;
			} else {
				checkingCondition = checkingCondition + " and " + "@" + keySet + " ='" + htmlAttributes.get(keySet)
						+ "'";
			}
		}
		return checkingCondition;
	}

	public String extractTagContent(HtmlPage page, String tag, String checkingCondition) {
		HtmlPage inpage=page;
		if (tag.equals("div")) {
			//System.out.println(inpage.asXml());
			HtmlDivision div = (HtmlDivision) inpage.getByXPath("//" + tag + "[" + checkingCondition + "]").get(0);			
			return div.asXml();
		} else if (tag.equals("span")) {
			HtmlSpan span = (HtmlSpan) inpage.getByXPath("//" + tag + "[" + checkingCondition + "]").get(0);
			return span.asXml();
		} else if (tag.equals("h1")) {
			HtmlHeading1 h1 = (HtmlHeading1) inpage.getByXPath("//" + tag + "[" + checkingCondition + "]").get(0);
			return h1.asXml();
		} else if (tag.equals("h2")) {
			System.out.println(
					"Tag" + tag + " Condition :" + " getByXPath(" + "//" + tag + "[" + checkingCondition + "])");
			
			HtmlHeading2 h2 = (HtmlHeading2) inpage.getByXPath("//" + tag + "[" + checkingCondition + "]").get(0);			
			return h2.asXml();
		} else if (tag.equals("h3")) {
			HtmlHeading3 h3 = (HtmlHeading3) inpage.getByXPath("//" + tag + "[" + checkingCondition + "]").get(0);
			return h3.asXml();
		} else if (tag.equals("h4")) {
			HtmlHeading4 h4 = (HtmlHeading4) inpage.getByXPath("//" + tag + "[" + checkingCondition + "]").get(0);
			return h4.asXml();
		} else if (tag.equals("h5")) {
			HtmlHeading5 h5 = (HtmlHeading5) inpage.getByXPath("//" + tag + "[" + checkingCondition + "]").get(0);
			return h5.asXml();
		} else if (tag.equals("h6")) {
			HtmlHeading6 h6 = (HtmlHeading6) inpage.getByXPath("//" + tag + "[" + checkingCondition + "]").get(0);
			return h6.asXml();
		} else if (tag.equals("p")) {
			HtmlParagraph paraGraph = (HtmlParagraph) inpage.getByXPath("//" + tag + "[" + checkingCondition + "]").get(0);
			return paraGraph.asXml();
		} else {
			return "Error";
		}
	}

	public String extractTagContent(HtmlPage page, String tag, String attribute, String attributeName) {
		if (tag.equals("div")) {
			HtmlDivision div = (HtmlDivision) page
					.getByXPath("//" + tag + "[@" + attribute + "='" + attributeName + "']").get(0);
			return div.asXml();
		} else if (tag.equals("span")) {
			HtmlSpan span = (HtmlSpan) page.getByXPath("//" + tag + "[@" + attribute + "='" + attributeName + "']")
					.get(0);
			return span.asXml();
		} else if (tag.equals("h1")) {
			HtmlHeading1 h1 = (HtmlHeading1) page
					.getByXPath("//" + tag + "[@" + attribute + "='" + attributeName + "']").get(0);
			return h1.asXml();
		} else if (tag.equals("h2")) {
			HtmlHeading2 h2 = (HtmlHeading2) page
					.getByXPath("//" + tag + "[@" + attribute + "='" + attributeName + "']").get(0);
			return h2.asXml();
		} else if (tag.equals("h3")) {
			HtmlHeading3 h3 = (HtmlHeading3) page
					.getByXPath("//" + tag + "[@" + attribute + "='" + attributeName + "']").get(0);
			return h3.asXml();
		} else if (tag.equals("h4")) {
			HtmlHeading4 h4 = (HtmlHeading4) page
					.getByXPath("//" + tag + "[@" + attribute + "='" + attributeName + "']").get(0);
			return h4.asXml();
		} else if (tag.equals("h5")) {
			HtmlHeading5 h5 = (HtmlHeading5) page
					.getByXPath("//" + tag + "[@" + attribute + "='" + attributeName + "']").get(0);
			return h5.asXml();
		} else if (tag.equals("h6")) {
			HtmlHeading6 h6 = (HtmlHeading6) page
					.getByXPath("//" + tag + "[@" + attribute + "='" + attributeName + "']").get(0);
			return h6.asXml();
		} else {
			return "Error";
		}
	}
}