/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.allkhmernews.wep.controller;

import com.allkhmernews.wep.model.Article;
import com.allkhmernews.wep.model.filter.ArticleFilter;
import com.allkhmernews.wep.service.ArticleService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author 
 */
@RestController
@RequestMapping("/api/v2")
public class ArticleRestController {
    private ArticleService articleService;
    @Autowired
    public ArticleRestController (ArticleService articleServicer){
        this.articleService = articleServicer;
    }
 @GetMapping("/articles")
 public Map<String, Object> findAll(){
		List<Article> articles = articleService.finall();
		Map<String, Object> response = new HashMap<>();	
		if(!articles.isEmpty()){
			response.put("message", "No article!");
			response.put("status", true);
                        response.put("data", articles);
//			response.put("paging", paging);
		}else{
                    response.put("message", "Success!");
			response.put("status", false);
		}
		return response;
	}
 @PostMapping("/save")
	public boolean save(@RequestBody Article article){
		System.out.println(article);
		return articleService.save(article);
	}
	
	@GetMapping("/articles/{id}")
	public Article findOne(@PathVariable("id") Integer id){
		System.out.println(id);
		return articleService.findOne(id);
	}
	
	@PutMapping("/update")
	public boolean update(@RequestBody Article article){
		System.out.println(article);
		return articleService.update(article);
	}
	
	@DeleteMapping("/articles/{id}")
	public ResponseEntity<Map<String, Object>> remove(@PathVariable("id") Integer id){
		System.out.println(id);
		Map<String, Object> response = new HashMap<>();
		if(articleService.remove(id)){
			response.put("message", "Removed Successfully!");
			response.put("status", true);
                        System.out.println("delete ok");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
                        
		}
		return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
	}
	
}
