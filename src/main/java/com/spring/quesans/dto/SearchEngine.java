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
	@Override
	public String toString() {
		return "SearchEngine [id=" + id + ", searchEngineName=" + searchEngineName + ", searchEngineURL="
				+ searchEngineURL + "]";
	}
	                                       
}
