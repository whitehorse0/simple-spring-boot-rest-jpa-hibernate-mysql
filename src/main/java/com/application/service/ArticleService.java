/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.service;

import com.application.dao.IArticleDAO;
import com.application.entity.Article;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WhiteHorse <eka378putra@gmail.com>
 */
@Service
public class ArticleService implements IArticleService {
    @Autowired
    private IArticleDAO articleDAO;

    @Override
    public List<Article> getAllArticles() {
        return articleDAO.getAllArticle();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Article getArticleById(int articleId) {
        Article articleObj = articleDAO.getArticleById(articleId);
        return articleObj;
    }

    @Override
    public synchronized boolean addArticle(Article article) {
        if (articleDAO.articleExists(article.getTitle(), article.getCategory())) {
            return false;
        } else {
            articleDAO.addArticle(article);
            return true;
        }
    }

    @Override
    public void updateArticle(Article article) {
        articleDAO.updateArticle(article);
    }

    @Override
    public void deleteArticle(int articleId) {
        articleDAO.deleteArticle(articleId);
    }
    
}
