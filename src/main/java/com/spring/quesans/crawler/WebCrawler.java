package com.spring.quesans.crawler;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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
import com.gargoylesoftware.htmlunit.html.HtmlPage;
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

			if (tag.equals("div")) {
				HtmlDivision div = (HtmlDivision) page
						.getByXPath("//" + tag + "[@" + attribute + "='" + attributeName + "']").get(0);
				System.out.println("Tag"+ tag+" Condition :"+" getByXPath("+"//" + tag + "[@" + attribute + "='" + attributeName + "'])");
				return div.asXml();
			} else if (tag.equals("span")) {
				HtmlSpan span = (HtmlSpan) page.getByXPath("//" + tag + "[@" + attribute + "='" + attributeName + "']")
						.get(0);
				return span.asXml();
			} else {
				return "Error";
			}

		} catch (Exception e) {
			System.out.println("Class based exception occured" + e.getMessage());
			return "Exception Error";
		}
	}

	public String getContentByAttributes(String URL, String tag, Map<String, String> attributes) throws Exception {
		try {
			// System.out.println("Input values :"+URL+" :"+tag+" :"+attribute+"
			// :"+attributeName);
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
			System.out.println("Checking Condition :" + "//" + tag + "[" + checkingCondition + "]");
			WebClient webClient = WebCrawler.getProxyWebConnection();
			HtmlPage page = webClient.getPage(URL);
			File googlePage = new File("googlePage.html");
			FileUtils.writeStringToFile(googlePage,page.asXml());
			System.out.println("Tag"+ tag);
			if (tag.equals("div")) {			
				HtmlDivision div = (HtmlDivision) page.getByXPath("//" + tag + "[" + checkingCondition + "]").get(0);
				System.out.println("Tag"+ tag+" Condition :"+" getByXPath("+"//" + tag + "[" + checkingCondition + "])");
				return div.asXml();
			} else if (tag.equals("span")) {
				HtmlSpan span = (HtmlSpan) page.getByXPath("//" + tag + "[" + checkingCondition + "]").get(0);
				return span.asXml();
			} else {
				return "Error";
			}

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
}