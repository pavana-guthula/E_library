package com.assignment.elibrary.service;

import com.assignment.elibrary.pojo.User_DTO;
import com.assignment.elibrary.pojo.entity.User;
import com.assignment.elibrary.repository.UserRepository;
import com.assignment.elibrary.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserTypeRepository userTypeRepository;

    public ModelAndView doLogin(User_DTO user_dto, HttpSession session){
        Map attributes = new HashMap();
        if(null != user_dto.getUsername()){
            User user;
            if(null!=(user = userRepository.findByUserName(user_dto.getUsername()))&&
            userRepository.findByUserName(user_dto.getUsername()).getPassword().equals(user_dto.getPassword())) {
                session.setAttribute("userType", userTypeRepository.findById(user.getUserTypeId()).getUserType());
                session.setAttribute("name", user_dto.getUsername());
                session.setAttribute("greetingname",userRepository.findByUserName(
                        user_dto.getUsername()).getName());
                return new ModelAndView("welcomepage", attributes);
            }
            else {
                attributes.put("errorMessage","Username or Password is incorrect. Please Enter Valid Credentials");
                attributes.put("redirect","login");
                return new ModelAndView("errorPage", attributes);
            }
        }
        else if(null!=session.getAttribute("name")){
            attributes.put("greetingname",userRepository.findByUserName(
                    session.getAttribute("name").toString()).getName());
            return new ModelAndView("welcomepage",attributes);
        }
        else{
            attributes.put("errorMessage","Session terminated!! Please Login");
            return new ModelAndView("errorPage",attributes);
        }
    }
}
