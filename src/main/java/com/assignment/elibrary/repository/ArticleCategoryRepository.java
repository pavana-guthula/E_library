package com.assignment.elibrary.repository;

import com.assignment.elibrary.pojo.entity.ArticleCategory;
import org.springframework.data.repository.CrudRepository;

public interface ArticleCategoryRepository extends CrudRepository<ArticleCategory, Integer> {

    public ArticleCategory findById(int id);
}
