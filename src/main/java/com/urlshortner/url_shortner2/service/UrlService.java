package com.urlshortner.url_shortner2.service;

import com.urlshortner.url_shortner2.model.Url;
import com.urlshortner.url_shortner2.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlService {
    @Autowired
    private UrlRepository urlRepository;

    public String shortnenUrl(String longUrl) {
        String shortCode;

        do {
            shortCode = UUID.randomUUID().toString().replace("-", "").substring(0, 6);
        } while (urlRepository.findByShortCode(shortCode).isPresent());

        Url url = new Url(longUrl, shortCode);
        urlRepository.save(url);

        return shortCode;
    }

    @Cacheable(value = "urls", key = "#shortCode")
    public String getOriginalUrl(String shortCode){
        return urlRepository.findByShortCode(shortCode)
                .map(url -> {
                    url.incrementClickCount();
                    urlRepository.save(url);
                    return url.getOriginalUrl();
                })
                .orElse(null);
    }

    public int getStats(String shortCode){
        return urlRepository.findByShortCode(shortCode)
                .map(Url::getClickCount)
                .orElse(-1);
    }
}
