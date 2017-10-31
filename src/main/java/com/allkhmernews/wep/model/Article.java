package com.allkhmernews.wep.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;

/**
 * Created by User on 12-Jun-17.
 */
public class Article {
    @Min(1)
    private int id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String author;

    private String thumbnail;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    private Category category;
    
    public  Article(){
        super();
    }
    public Article(int id, String title, String author, String thumbnail) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.thumbnail = thumbnail;
   
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id=id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", picture='" + thumbnail + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
