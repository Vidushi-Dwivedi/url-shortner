package com.urlshortner.url_shortner2.repository;

import com.urlshortner.url_shortner2.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long>, CrudRepository<Url, Long> {
    Optional<Url> findByShortCode(String shortCode);
}
