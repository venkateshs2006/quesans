package com.spring.quesans.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Entity
@Table(name = "searchengine")
@Repository
public class SearchEngine {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String searchEngineName;
	private String searchEngineURL;
	private String resultTag;
	private String resultAttribute;
	private String resultTagID;
	private String tagPosition;
	private String regexDetails;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSearchEngineName() {
		return searchEngineName;
	}
	public void setSearchEngineName(String searchEngineName) {
		this.searchEngineName = searchEngineName;
	}
	public String getSearchEngineURL() {
		return searchEngineURL;
	}
	public void setSearchEngineURL(String searchEngineURL) {
		this.searchEngineURL = searchEngineURL;
	}
	public String getResultTag() {
		return resultTag;
	}
	public void setResultTag(String resultTag) {
		this.resultTag = resultTag;
	}
	public String getResultAttribute() {
		return resultAttribute;
	}
	public void setResultAttribute(String resultAttribute) {
		this.resultAttribute = resultAttribute;
	}
	public String getResultTagID() {
		return resultTagID;
	}
	public void setResultTagID(String resultTagID) {
		this.resultTagID = resultTagID;
	}
	public String getTagPosition() {
		return tagPosition;
	}
	public void setTagPosition(String tagPosition) {
		tagPosition = tagPosition;
	}
	public String getRegexDetails() {
		return regexDetails;
	}
	public void setRegexDetails(String regexDetails) {
		this.regexDetails = regexDetails;
	}
	@Override
	public String toString() {
		return "SearchEngine [id=" + id + ", searchEngineName=" + searchEngineName + ", searchEngineURL="
				+ searchEngineURL + ", resultTag=" + resultTag + ", resultAttribute=" + resultAttribute
				+ ", resultTagID=" + resultTagID + ", TagPosition=" + tagPosition + ", regexDetails=" + regexDetails
				+ "]";
	}                                       
}
