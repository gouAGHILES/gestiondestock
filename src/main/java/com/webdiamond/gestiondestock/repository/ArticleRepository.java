package com.webdiamond.gestiondestock.repository;

import com.webdiamond.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {



}
