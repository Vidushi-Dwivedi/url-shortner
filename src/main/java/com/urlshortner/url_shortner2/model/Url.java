package com.urlshortner.url_shortner2.model;

public class Url {
    private String originalUrl;
    private String shortCode;
    private int clickCounts;

    public Url(String originalUrl, String shortCode){
        this.originalUrl = originalUrl;
        this.shortCode = shortCode;
        this.clickCounts = 0;
    }

    public String getOriginalUrl() { return originalUrl; }
    public String getShortCode() { return shortCode; }
    public int getClickCount() { return clickCounts; }

    public void incrementClickCount() {
        this.clickCounts++;
    }
}
