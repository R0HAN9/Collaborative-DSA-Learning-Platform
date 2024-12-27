package com.Collaborative.DSALearningPlatform.Models;

public class TechGuideLink {
    private String title;
    private String url;

    // Constructor
    public TechGuideLink(String title, String url) {
        this.title = title;
        this.url = url;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
