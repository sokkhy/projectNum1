package com.allkhmernews.wep.service;

import com.allkhmernews.wep.model.Article;
import com.allkhmernews.wep.model.categoryfilter.CategoryFilter;
import com.allkhmernews.wep.model.filter.ArticleFilter;
import com.allkhmernews.wep.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 12-Jun-17.
 */
@Service
public class ArticleServiceIm implements ArticleService {
    private ArticleRepository articleRepository;
    @Autowired
    public ArticleServiceIm(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }



    @Override
    public Article findOne(int id) {
      return  articleRepository.findOne(id);
    }
    @Override
    public boolean remove(int id) {
        return articleRepository.remove(id);

    }

    @Override
    public boolean save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public boolean update(Article article) {
        return articleRepository.update(article);
    }

    @Override
    public int totalPage() {
        return articleRepository.totalPage();
    }
    @Override
    public List<Article> findAll(int page) {
        page = (page*5)-5;
        List<Article> article=articleRepository.findAll(page);
        return article;
    }


//    @Override
//    public List<Article> findall(int limit, int page) {
//        int maxpage=lastpage(limit);
//        if(limit<5)limit=5;
//        if(page<1)page=1;
//        page--;
//        if(page>maxpage)page=maxpage;
//        return articleRepository.findall(limit, page*limit);
//    }
//
//    @Override
//    public int lastpage(int limit) {
//        int maxpage=findAll().size()/limit;
//        if(findAll().size()%5!=0)maxpage++;
//        return maxpage;
//    }

    @Override
    public List<Article> search(CategoryFilter categoryFilter) {
        return articleRepository.search(categoryFilter);
    }

    @Override
    public List<Article> finall() {
      return articleRepository.findall();
               
    }

    
   }