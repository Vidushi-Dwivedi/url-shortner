package com.urlshortner.url_shortner2.controller;

import com.urlshortner.url_shortner2.model.Url;

import com.urlshortner.url_shortner2.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class UrlController {
    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<String> shorten(@RequestParam String url) {
        String shortCode = urlService.shortnenUrl(url);
        return ResponseEntity.ok("http://localhost:8080/" + shortCode);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<?> redirect(@PathVariable String shortCode){
        String originalUrl = urlService.getOriginalUrl(shortCode);
        if(originalUrl != null){
            return ResponseEntity.status(302).location(URI.create(originalUrl)).build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/stats/{shortCode}")
    public ResponseEntity<?> stats(@PathVariable String shortCode) {
        int count = urlService.getStats(shortCode);
        if(count != -1){
            return ResponseEntity.ok("clicks: " + count);
        }

        return ResponseEntity.notFound().build();
    }
}