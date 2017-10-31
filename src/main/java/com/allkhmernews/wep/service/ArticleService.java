package com.allkhmernews.wep.service;

import com.allkhmernews.wep.model.Article;
import com.allkhmernews.wep.model.categoryfilter.CategoryFilter;
import com.allkhmernews.wep.model.filter.ArticleFilter;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 12-Jun-17.
 */
@Repository
public interface ArticleService {
    List<Article> findAll(int page);
    List<Article> finall();
    Article findOne(int id);
    boolean remove(int id);
    boolean save(Article article);
    boolean update(Article article);
//    List<Article> findall(int limit, int page);
//    int lastpage(int limit);
int totalPage();
List<Article> search(CategoryFilter categoryFilter);
    
}
