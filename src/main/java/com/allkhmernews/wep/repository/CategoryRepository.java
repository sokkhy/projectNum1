/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allkhmernews.wep.repository;

import com.allkhmernews.wep.model.Article;
import com.allkhmernews.wep.model.Category;
import java.util.List;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MSI
 */
@Repository
public interface CategoryRepository {
//    @Select("select * from tbcategory")
//       @Results({
//       @Result(property="id", column="id"),
//       @Result(property="name", column="name"),
//        @Result(property="article", column="id", many=@Many(select=" findArticleByCategoryId"))       
//       })      
//    List<Category> findAll(); 
//    
//    @Select("SELECT * FROM tbarticle WHERE category_id=#{id}")
//    public List<Article> findArticleByCategoryId(Integer id);
    
  @Select("SELECT id, name FROM tbcategory")
	@Results({
		@Result(property="id", column="id"),
		@Result(property="name", column="name")
	})
	List<Category> findAll();
        
        @Select("SELECT id, name FROM tbcategory")
	@Results({
		@Result(property="id", column="id"),
		@Result(property="name", column="name"),
		@Result(property="articles", column="id", many=@Many(select="findArticleByCategory"))
	})
	List<Category> findAllCategoryWithArticle();
        
}
