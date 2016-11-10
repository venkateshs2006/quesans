package com.spring.quesans.crawler;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

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
		return (webClient);
	}
	public static WebClient getWebConnection() {
		@SuppressWarnings("deprecation")
		WebClient webClient = new WebClient(BrowserVersion.FIREFOX_38);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		return (webClient);
	}
	public String getPageContent(String URL) {
		WebClient webClient = WebCrawler.getWebConnection();
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
			WebClient webClient = WebCrawler.getWebConnection();
			final HtmlPage page = webClient.getPage(URL);
			final HtmlDivision div = page.getHtmlElementById(elementId);
			return div.getTextContent();
		} catch (Exception e) {
			System.out.println("Element based Exception occured" + e.getMessage());
			return "Page Crawling is Failed. Please Contact Administrator";
		}
	}

	public String getContentByClass(String URL, String tag, String className) throws Exception {
		try {
			WebClient webClient = WebCrawler.getWebConnection();
			final HtmlPage page = webClient.getPage(URL);
			HtmlDivision div = (HtmlDivision) page.getByXPath("//" + tag + "[@class='" + className + "']").get(0);
			return div.asXml();
		} catch (Exception e) {
			System.out.println("Class based exception occured" + e.getMessage());
			return "Page Crawling is Failed. Please Contact Administrator";
		}
	}
	public String getContentByAttribute(String URL, String tag, String attribute, String attributeName) throws Exception {
		try {
			System.out.println("Input values :"+URL+"   :"+tag+"  :"+attribute+"  :"+attributeName);			
			WebClient webClient = WebCrawler.getWebConnection();
			final HtmlPage page = webClient.getPage(URL);
			HtmlDivision div = (HtmlDivision) page.getByXPath("//" + tag + "[@"+attribute+"='" + attributeName + "']").get(0);
			return div.asXml();
		} catch (Exception e) {
			System.out.println("Class based exception occured" + e.getMessage());
			return "Page Crawling is Failed. Please Contact Administrator";
		}
	}

	public String getContentByTagId(String URL, String tag, String elementId) throws Exception {
		try {
			WebClient webClient = WebCrawler.getWebConnection();
			final HtmlPage page = webClient.getPage(URL);
			HtmlDivision div = (HtmlDivision) page.getByXPath("//" + tag + "[@id='" + elementId + "']").get(0);
			return div.asXml();
		} catch (Exception e) {
			System.out.println("Class based exception occured" + e.getMessage());
			return "Page Crawling is Failed. Please Contact Administrator";
		}
	}

	
}