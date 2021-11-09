package com.assignment.elibrary.pojo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Articles")
public class Article {

    @Id
    @Column( name = "Article_ID", updatable = false, nullable = false)
    @GeneratedValue
    int articleId;

    @Column(name = "Title", nullable = false)
    String articleTitle;

    @Column( name = "Author_ID", nullable = false)
    int articleAuthorId;

    @Column( name = "Category_ID", nullable = false)
    int articleCategoryId;

    @Column( name = "Description")
    String articleDescription;

    @Column( name = "Content", nullable = false, length = 65555)
    String articleContent;

    @Column( name = "Published_date", nullable = false)
    String dateOfPublish;

    @ManyToOne
    @JoinColumn( name = "Category_ID", referencedColumnName = "Category_ID", insertable = false, updatable = false)
    private ArticleCategory articleCategory;

    @ManyToOne
    @JoinColumn( name = "Author_ID", referencedColumnName = "User_ID", insertable = false, updatable = false)
    private User user;

}
