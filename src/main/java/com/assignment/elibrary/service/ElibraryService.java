package com.assignment.elibrary.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Service
public class ElibraryService {
    public ModelAndView showErrorPage(String errorMessage, String redirect){
        Map attributes = new HashMap();
        attributes.put("errorMessage", "Session termination!! Please Login again :)");
        attributes.put("redirect",redirect);
        return new ModelAndView("errorPage",attributes);
    }

}
