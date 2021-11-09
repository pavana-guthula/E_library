package com.assignment.elibrary.service;

import com.assignment.elibrary.pojo.Article_DTO;
import com.assignment.elibrary.pojo.entity.Article;
import com.assignment.elibrary.pojo.entity.ArticleCategory;
import com.assignment.elibrary.pojo.entity.User;
import com.assignment.elibrary.repository.ArticleCategoryRepository;
import com.assignment.elibrary.repository.ArticleRepository;
import com.assignment.elibrary.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ArticleService {

    @Autowired
    ArticleCategoryRepository articleCategoryRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ElibraryService elibraryService;

    public ModelAndView newArticle(HttpSession session){
        Map attributes = new HashMap();
        if(null!=session.getAttribute("name")){
            try {
                attributes.put("command", new Article_DTO());
                attributes.put("categoryList",
                        (ArrayList<ArticleCategory>) articleCategoryRepository.findAll());
                return new ModelAndView("newarticlepage", attributes);
            }
            catch(Exception exception){
                elibraryService.showErrorPage("Something Went Wrong!! Please try again","login");
            }
        }
        return elibraryService.showErrorPage("Session termination!! Please Login again :)","login");
    }

    public ModelAndView showAllArticles(HttpSession session){
        Map attributes = new HashMap();
        if(null!=session.getAttribute("name")){
            try {
                attributes.put("categoryList", (ArrayList<ArticleCategory>)
                        articleCategoryRepository.findAll());
                attributes.put("articleList", (ArrayList<Article>)
                        articleRepository.findAll());
                return new ModelAndView("listarticlepage", attributes);
            }
            catch(Exception exception){
                elibraryService.showErrorPage("Something Went Wrong!! Please try again","login");
            }
        }
        return elibraryService.showErrorPage("Session termination!! Please Login again :)","login");
    }

    public ModelAndView showAnArticle(HttpSession session, int id) {
        Map attributes = new HashMap();
        if (null != session.getAttribute("name")) {
            try {
                Article_DTO article_dto = modelMapper.map(articleRepository.findByArticleId(id), Article_DTO.class);
                article_dto.setArticleAuthorName(userRepository.findById(article_dto.getArticleAuthorId()).getName());
                article_dto.setArticleCategoryName(articleCategoryRepository
                        .findById(article_dto.getArticleCategoryId()).getCategoryName());
                attributes.put("article", article_dto);
                return new ModelAndView("showarticlepage", attributes);
            }
            catch(Exception exception){
                elibraryService.showErrorPage("Something Went Wrong!! Please try again","login");
            }
        }
        return elibraryService.showErrorPage("Session termination!! Please Login again :)","login");
    }

    public ModelAndView editArticle(HttpSession session, int id){
        Map attributes = new HashMap();
        if(null!=session.getAttribute("name")){
            try {
                Article_DTO article_dto = modelMapper.map(articleRepository.findByArticleId(id), Article_DTO.class);
                attributes.put("command", new Article_DTO());
                attributes.put("article", article_dto);
                attributes.put("author", userRepository
                        .findById(article_dto.getArticleAuthorId()).getUserName());
                return new ModelAndView("editarticlepage", attributes);
            }
            catch(Exception exception){
                elibraryService.showErrorPage("Something Went Wrong!! Please try again","login");
            }
        }
        return elibraryService.showErrorPage("Session termination!! Please Login again :)","login");
    }

    public ModelAndView deleteArticle(HttpSession session, int id){
        Map attributes = new HashMap();
        if(null!=session.getAttribute("name")){
            try {
                if (session.getAttribute("name").toString().equals(
                        userRepository.findById(articleRepository.findByArticleId(id)
                                .getArticleAuthorId()).getUserName())) {
                    articleRepository.deleteById(id);
                    return new ModelAndView("redirect:/articles");
                }
                return elibraryService.showErrorPage("Unauthorized Operation: The Article is not created by" + session.getAttribute("name")
                        , "welcome");
            }
            catch(Exception exception){
                elibraryService.showErrorPage("Something Went Wrong!! Please try again","login");
            }
        }
        return elibraryService.showErrorPage("Session termination!! Please Login again :)","login");
    }

    public ModelAndView saveArticle(HttpSession session, Article_DTO article_dto){
        if(null!=session.getAttribute("name")) {
            try {
                Map attributes = new HashMap();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
                Article article = modelMapper.map(article_dto, Article.class);
                simpleDateFormat.applyLocalizedPattern("dd/MM/yyyy");
                User user = userRepository.findByUserName(article_dto.getArticleAuthorName());
                article.setDateOfPublish(simpleDateFormat.format(new Date().getTime()).toString());
                article.setArticleAuthorId(user.getId());
                if (user.getUserType().getUserType().equals("Author")) {
                    int savedId = articleRepository.save(article).getArticleId();
                    return new ModelAndView("redirect:/article/" + savedId, attributes);
                }
                return elibraryService.showErrorPage("Access Denied!! Unauthorised Action", "login");
            }
            catch(Exception exception){
                elibraryService.showErrorPage("Something Went Wrong!! Please try again","login");
            }
        }
        return elibraryService.showErrorPage("Session termination!! Please Login again :)", "login");
    }

    public ModelAndView updateArticle(HttpSession session, int id, Article_DTO article_dto){
        if(null!=session.getAttribute("name")) {
            try {
                Map attributes = new HashMap();
                Article previousArticles = articleRepository.findByArticleId(id);
                Article article = modelMapper.map(article_dto, Article.class);
                article.setArticleCategoryId(previousArticles.getArticleCategoryId());
                article.setArticleAuthorId(previousArticles.getArticleAuthorId());
                article.setDateOfPublish(previousArticles.getDateOfPublish());
                article.setArticleId(id);
                if (previousArticles.getUser().getUserType().getUserType().equals("Author")) {
                    articleRepository.save(article);
                    return new ModelAndView("redirect:/article/" + id);
                }
                return elibraryService.showErrorPage("Access Denied!! Unauthorised Action", "login");
            }
            catch(Exception exception){
                elibraryService.showErrorPage("Something Went Wrong!! Please try again","login");
            }
        }
        return elibraryService.showErrorPage("Session termination!! Please Login again :)", "login");
    }

    public ModelAndView myArticles(HttpSession session){
        if(null!=session.getAttribute("name")){
            try {
                Map attributes = new HashMap();
                int userId = userRepository.findByUserName(session.getAttribute("name").toString()).getId();
                ArrayList<Article> myArticleList = articleRepository.findByArticleAuthorId(userId);
                if (myArticleList.size() > 0) {
                    attributes.put("myArticleList", myArticleList);
                } else {
                    attributes.put("noArticle", "No article found");
                }
                return new ModelAndView("myarticlepage", attributes);
            }
            catch(Exception exception){
                elibraryService.showErrorPage("Something Went Wrong!! Please try again","login");
            }
        }
        return elibraryService.showErrorPage("Session termination!! Please Login again :)","login");
    }
}
