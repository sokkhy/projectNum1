/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allkhmernews.wep.model;

import java.util.List;
import javax.validation.constraints.NotNull;

/**
 *
 * @author MSI
 */
public class Category {

	private int id;
	private String name;
	
	private List<Article> articles;
	
	public Category(){}
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", articles=" + articles + "]";
	}
       
    
}
