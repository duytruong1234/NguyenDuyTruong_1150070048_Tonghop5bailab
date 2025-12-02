package com.example.lab4duytruong;

public class TopicItem {
    private int imageResId;
    private String title;

    public TopicItem(int imageResId, String title) {
        this.imageResId = imageResId;
        this.title = title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }
}
