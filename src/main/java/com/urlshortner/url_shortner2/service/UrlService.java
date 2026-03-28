package com.urlshortner.url_shortner2.service;

import com.urlshortner.url_shortner2.model.Url;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UrlService {
    private Map<String, Url> urlStore = new HashMap<>();

    public String shortnenUrl(String longUrl) {
        String shortCode = UUID.randomUUID().toString().substring(0,6);
        Url url = new Url(longUrl, shortCode);
        urlStore.put(shortCode, url);
        return shortCode;
    }

    public String getOriginalUrl(String shortCode){
        Url url = urlStore.get(shortCode);

        if(url != null){
            url.incrementClickCount();
            return url.getOriginalUrl();
        }

        return null;
    }

    public int getStats(String shortCode){
        Url url = urlStore.get(shortCode);
        if(url != null){ return url.getClickCount(); }

        return -1;
    }
}
