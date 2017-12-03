/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.dao;

import com.application.entity.Article;
import java.util.List;

/**
 *
 * @author WhiteHorse <eka378putra@gmail.com>
 */
public interface IArticleDAO {
    List<Article> getAllArticle();
    Article getArticleById(int articleId);
    void addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(int articleId);
    boolean articleExists(String title, String category);
    
}
