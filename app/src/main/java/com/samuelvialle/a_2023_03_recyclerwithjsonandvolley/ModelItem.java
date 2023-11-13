package com.samuelvialle.a_2023_03_recyclerwithjsonandvolley;

public class ModelItem {
    private final String imageUrl;
    private final String creator;
    private final String likes;

    public ModelItem(String imageUrl, String creator, String likes) {
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

    public String getLikes() {
        return likes;
    }
}
