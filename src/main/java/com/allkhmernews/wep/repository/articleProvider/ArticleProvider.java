package com.allkhmernews.wep.repository.articleProvider;

import com.allkhmernews.wep.model.categoryfilter.CategoryFilter;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by MSI on 7/6/2017.
 */
public class ArticleProvider {
    public String findAll(){
        return new SQL(){{
            SELECT("A.id, A.title, A.author, A.thumbnail");
            SELECT("C.id AS \"categoryId\", C.name");
            FROM("tbarticle A"); 
            INNER_JOIN("tbcategory C ON C.id = A.category_id");
            ORDER_BY("id ASC limit 6 offset #{offset}");
        }}.toString();
    }
    public String findOne(){
        return new SQL(){{
            SELECT("id, title, author, thumbnail");
            FROM("tbarticle");
            WHERE("id = #{id}");
        }}.toString();
    }
    public String save(){
        return new SQL(){{
            INSERT_INTO("tbarticle");
            VALUES("id", "#{id} ");
            VALUES("title", "#{title} ");
            VALUES("author", "#{author} ");
            VALUES("thumbnail", "#{thumbnail} ");
             VALUES("category_id", "#{category.id} ");
        }}.toString();
    }
    public String remove(){
        return new SQL(){{
            DELETE_FROM("tbarticle");
            WHERE("id = #{id}");
        }}.toString();
    }
    public String update(){
        return new SQL(){{
            UPDATE("tbarticle set title=#{title}, author=#{author}, thumbnail=#{thumbnail}, category_id=#{category.id}");
            WHERE("id =#{id}");
        }}.toString();
    }
    public String totalpage(){
        return new SQL(){{
            SELECT("COUNT (id)/6");
            FROM("tbarticle");
        }}.toString();
    }
    public String search(CategoryFilter categoryFilter){
        
        return new SQL(){{
            SELECT("a.id,a.title,a.author,a.thumbnail,c.id as \"cid\", c.name as \"cname\" ");
            FROM("tbarticle a");
            INNER_JOIN("tbcategory c ON a.category_id=c.id");
            if(categoryFilter.getCategoryid()!=null){
                WHERE("a.category_ID=#{categoryid}");
            }
            if(categoryFilter.getArticletitle()!=null){
                WHERE("a.title=#{articletitle}");
            }
        }}.toString();
    }
}
