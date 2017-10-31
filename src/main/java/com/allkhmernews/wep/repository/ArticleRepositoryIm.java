package com.allkhmernews.wep.repository;

//package com.allkhmernews.wep.repository;
//
//import com.allkhmernews.wep.model.Article;
//import com.github.javafaker.Faker;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Repository;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
///**
// * Created by User on 12-Jun-17.
// */
//@Repository
//public class ArticleRepositoryIm implements ArticleRepository {
//    List<Article> articles;
//    @Qualifier("dataSource")
//    @Autowired
// private DataSource dataSource;
//
//    public ArticleRepositoryIm() {
//
//        articles = new ArrayList<Article>();
//        for (int i = 0; i <= 10; i++) {
//            Article article = new Article(i + 1, "wonderwoman", "jam", "http://7bna.net/images/railway/railway-1.jpg");
//            articles.add(article);
//        }
//
//    }
//
//    @Override
//    public List<Article> findAll() {
//        return articles;
//    }
//
//    @Override
//    public Article findOne(int id) {
//        for (Article article : articles) {
//            if (article.getId() == id) ;
//            return article;
//        }
//        return null;
//    }
//
//    @Override
//    public Boolean remove(int id) {
//        for (Article article : articles) {
//            if (article.getId() == id) {
//                articles.remove(article);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public boolean save(Article article) {
//        return this.articles.add(article);
//    }
//
//    @Override
//    public boolean update(Article article) {
//        return false;
//    }
//
//    @Override
//    public List<Article> findall(int limit, int page) {
//        ArrayList<Article> articles = new ArrayList<>();
//        try (Connection con = dataSource.getConnection()) {
//            String sql = "select * from tbarticle where limit ? offset?";
//            PreparedStatement p = con.prepareCall(sql);
//            p.setInt(1, limit);
//            p.setInt(2, (page - 1) * limit);
//            ResultSet rs = p.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String title = rs.getString("title");
//                String author = rs.getString("author");
//                String thumbnail = rs.getString("thumbnail");
//                Article article = new Article(id, title, author, thumbnail);
//                articles.add(article);
//            }
//
//            return articles;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
//
//
//
