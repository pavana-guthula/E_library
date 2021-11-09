package com.assignment.elibrary.repository;

import com.assignment.elibrary.pojo.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
    public ArrayList<Article> findByArticleCategoryId(int articleCategoryId);
    public Article findByArticleId(int articleId);
    public ArrayList<Article> findByArticleAuthorId(int authorId);
    public Article save(Article article);
}
