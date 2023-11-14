package com.samuelvialle.a_2023_03_recyclerwithjsonandvolley;

public class ModelItem {
    private final String imageUrl;
    private final String creator;
    private final int likes;

    public ModelItem(String imageUrl, String creator, int likes) {
        this.imageUrl = imageUrl;
        this.creator = creator;
        this.likes = likes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCreator() {
        return creator;
    }

    public int getLikes() {
        return likes;
    }
}
