package com.allkhmernews.wep.repository;

import com.allkhmernews.wep.model.Article;
import com.allkhmernews.wep.model.categoryfilter.CategoryFilter;
import com.allkhmernews.wep.repository.articleProvider.ArticleProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 12-Jun-17.
 */
@Repository
public interface ArticleRepository {
//    @Select("Select id,title,author,thumbnail from tbarticle order by id asc limit 10 offset #{offset}")
//    @Results({
//            @Result(property ="id",column = "id"),
//            @Result(property ="title",column = "title"),
//            @Result(property ="author",column = "author"),
//            @Result(property ="thumbnail",column = "thumbnail")
//    })
    @SelectProvider(method = "findAll", type = ArticleProvider.class)
            @Results({
            @Result(property ="category.id",column = "categoryId"),
            @Result(property ="category.name",column = "name"),
            @Result(property="id", column="id"),})
    List<Article> findAll(int page);
//    @Select("SELECT * FROM tbarticle WHERE id=#{id}")
    
@SelectProvider(method = "findOne", type = ArticleProvider.class)
    Article findOne(int id);
//    @Delete("Delete from tbarticle where id=#{id}")
    @DeleteProvider(method = "remove", type = ArticleProvider.class)
    Boolean remove(int id);
//    @Insert("insert into tbarticle(id,title,author,thumbnail) VALUES(#{id},#{title},#{author},#{thumbnail})")
    @InsertProvider(method = "save", type = ArticleProvider.class)
    boolean save (Article article);

//    @Update("Update tbarticle set title=#{title},author=#{author},thumbnail=#{thumbnail} where id=#{id}")
    @UpdateProvider(method = "update", type = ArticleProvider.class)
    boolean update(Article article);
//    @Select("Select id,title,author,thumbnail from tbarticles order by id asc limit #{limit} offset #{offset}")
//    List<Article> findall(@Param("limit")int limit, @Param("offset")int offset);
//@Select("select COUNT(id)/5 FROM tbarticle")
    @SelectProvider(method = "totalpage", type = ArticleProvider.class)
int totalPage();
@SelectProvider(method="search", type=ArticleProvider.class)
           @Results({
            @Result(property ="category.id",column = "id"),
            @Result(property ="category.name",column = "name")
    })
  List<Article> search(CategoryFilter filter);
@SelectProvider(method = "findAll", type = ArticleProvider.class)
    
            @Results({
            @Result(property ="category.id",column = "categoryId"),
            @Result(property ="category.name",column = "name"),
            @Result(property="id", column="id"),
            
    })
  List<Article> findall();
  
}
