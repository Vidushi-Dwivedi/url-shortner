package com.urlshortner.url_shortner2.model;

import com.fasterxml.jackson.annotation.JsonTypeId;

import jakarta.persistence.*;

@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalUrl;
    private String shortCode;
    private int clickCounts;

    public Url() {}

    public Url(String originalUrl, String shortCode){
        this.originalUrl = originalUrl;
        this.shortCode = shortCode;
        this.clickCounts = 0;
    }

    public Long getId() { return id; }
    public String getOriginalUrl() { return originalUrl; }
    public String getShortCode() { return shortCode; }
    public int getClickCount() { return clickCounts; }

    public void incrementClickCount() {
        this.clickCounts++;
    }
}
