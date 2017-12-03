/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.controller;

import com.application.entity.Article;
import com.application.service.IArticleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author WhiteHorse <eka378putra@gmail.com>
 */


@Controller
@RequestMapping("blog")
public class ArticleController {
    @Autowired
    private IArticleService articleService;
    
    @GetMapping("articles")
    public ResponseEntity<List<Article>> getAllArticle() {
        List<Article> list = articleService.getAllArticles();
        
        return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
    }
    
    @GetMapping("article/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable("id") Integer id) {
        Article article = articleService.getArticleById(id);
        
        return new ResponseEntity<Article>(article, HttpStatus.OK);
    }
    
    @PostMapping("article")
    public ResponseEntity<Void> addArticle(@RequestBody Article article, UriComponentsBuilder builder) {
        boolean flag = articleService.addArticle(article);
        
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/artivle/{id}").buildAndExpand(article.getArticleId()).toUri());
        
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @PutMapping("article")
    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
        articleService.updateArticle(article);
        
        return new ResponseEntity<Article>(article, HttpStatus.OK);
    }
    
    @DeleteMapping("article/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
        articleService.deleteArticle(id);
        
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    
    
    
    
    
    
}
