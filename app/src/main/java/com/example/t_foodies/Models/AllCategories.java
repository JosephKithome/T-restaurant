package com.example.t_foodies.Models;

import java.util.List;

public class AllCategories {

    String CategoryTitle;
    List<CategoryContent> categoryContentList;

    public AllCategories(String categoryTitle, List<CategoryContent> categoryContentList) {
        CategoryTitle = categoryTitle;
        this.categoryContentList = categoryContentList;
    }

    public String getCategoryTitle() {
        return CategoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        CategoryTitle = categoryTitle;
    }

    public List<CategoryContent> getCategoryContentList() {
        return categoryContentList;
    }

    public void setCategoryContentList(List<CategoryContent> categoryContentList) {
        this.categoryContentList = categoryContentList;
    }
}
