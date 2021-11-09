package com.assignment.elibrary.controller;

import com.assignment.elibrary.pojo.Article_DTO;
import com.assignment.elibrary.pojo.User_DTO;
import com.assignment.elibrary.service.ArticleService;
import com.assignment.elibrary.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LibraryController {

    @Autowired
    LoginService loginService;

    @Autowired
    ArticleService articleService;

    @GetMapping(value="/login")
    public Object showLoginPage(HttpSession session, ModelAndView modelAndView){
        if(null!=session.getAttribute("name")){
            return "redirect:/welcome";
        }
        modelAndView.addObject("command", new User_DTO());
        modelAndView.setViewName("loginpage");
        return modelAndView;
    }

    @GetMapping("/")
    public String redirectLogin(){
        return "redirect:/login";
    }

    @RequestMapping(value="/welcome")
    public Object welcomePage(@ModelAttribute("user") User_DTO user_dto, HttpSession session){
        return loginService.doLogin(user_dto, session);
    }

    @GetMapping(value = "/newarticle")
    public Object editArticle(HttpSession session, ModelAndView modelAndView){
        return articleService.newArticle(session);
    }

    @GetMapping(value = "/articles")
    public Object showArticleList(HttpSession session, ModelAndView modelAndView){
        return articleService.showAllArticles(session);
    }

    @GetMapping(value = "/article/{id}")
    public Object showArticle(@PathVariable("id") int id, HttpSession session){
        return articleService.showAnArticle(session, id);
    }

    @GetMapping(value = "/editarticle/{id}")
    public Object editArticle(@PathVariable("id") int id, HttpSession session){
        return articleService.editArticle(session, id);
    }

    @GetMapping(value = "/deletearticle/{id}")
    public Object deleteArticle(@PathVariable("id") int id, HttpSession session){
        return articleService.deleteArticle(session, id);
    }

    @GetMapping(value="/myarticles")
    public Object getMyArticles(HttpSession session, ModelAndView modelAndView){
        return articleService.myArticles(session);
    }

    @PostMapping(value="/save")
    public Object saveArticle(@ModelAttribute("article_dto") Article_DTO article_dto,
                              HttpSession session){
        return articleService.saveArticle(session, article_dto);
    }

    @PostMapping(value="/editarticle/update/{id}")
    public Object update(@PathVariable("id") int id, @ModelAttribute("article_dto") Article_DTO article_dto,
                         HttpSession session, ModelAndView modelAndView){
        return articleService.updateArticle(session, id, article_dto);
    }

    @GetMapping(value="/logout")
    public Object doLogout(HttpSession session){
        session.removeAttribute("name");
        session.removeAttribute("greetingname");
        session.removeAttribute("userType");
        return "redirect:/login";
    }
}
