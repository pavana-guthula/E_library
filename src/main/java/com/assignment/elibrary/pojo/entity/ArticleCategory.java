package com.assignment.elibrary.pojo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table( name = "Article_Category")
public class ArticleCategory {

    @Id
    @Column( name = "Category_ID", nullable = false, updatable = false)
    @GeneratedValue
    int categoryId;

    @Column( name = "Category_Name")
    String categoryName;

    @OneToMany( mappedBy = "articleCategory")
    private List<Article> articles;
}
