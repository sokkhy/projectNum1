package com.allkhmernews.wep.model.categoryfilter;

/**
 * Created by lor on 7/7/2017.
 */
public class CategoryFilter {
    private Integer categoryid;
    private String  articletitle;

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getArticletitle() {
        return articletitle;
    }

    public void setArticletitle(String articletitle) {
        this.articletitle = articletitle;
    }

    public CategoryFilter(Integer categoryid, String articletitle) {
        this.categoryid = categoryid;
        this.articletitle = articletitle;
    }
    public  CategoryFilter(){
        super();
    }
    @Override
    public String toString() {
        return "CategoryFilter{" +
                "categoryid=" + categoryid +
                ", articletitle='" + articletitle + '\'' +
                '}';
    }
}
