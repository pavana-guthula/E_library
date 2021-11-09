package com.assignment.elibrary.pojo;

import lombok.Data;

@Data
public class Article_DTO {
    int articleId;
    String articleTitle;
    int articleAuthorId;
    int articleCategoryId;
    String articleAuthorName;
    String articleDescription;
    String articleContent;
    String dateOfPublish;
    String articleCategoryName;
}
