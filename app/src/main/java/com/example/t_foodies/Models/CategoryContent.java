package com.example.t_foodies.Models;

public class CategoryContent {
    int itemId;
    int imageUrl;

    public CategoryContent(int itemId, int imageUrl) {
        this.itemId = itemId;
        this.imageUrl = imageUrl;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}

