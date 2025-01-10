package com.vyzasolutions.indiaweather.models;

public class NewsModel {

    private String title;
    private String timeAgo;
    private String imageUrl;

    public NewsModel(String title, String timeAgo, String imageUrl) {
        this.title = title;
        this.timeAgo = timeAgo;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimeAgo() {
        return timeAgo;
    }

    public void setTimeAgo(String timeAgo) {
        this.timeAgo = timeAgo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

