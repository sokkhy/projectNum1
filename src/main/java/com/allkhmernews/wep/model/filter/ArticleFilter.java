/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allkhmernews.wep.model.filter;

/**
 *
 * @author MSI
 */
public class ArticleFilter {

	private String title;
	private Integer categoryId;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	@Override
	public String toString() {
		return "ArticleFilter [title=" + title + ", categoryId=" + categoryId + "]";
	}    
}
