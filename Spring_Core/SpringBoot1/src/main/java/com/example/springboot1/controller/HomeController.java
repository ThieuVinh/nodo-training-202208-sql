package com.example.springboot1.controller;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    private final static Logger LOGGER = Logger.getLogger(HomeController.class);

    @RequestMapping(value = "/")
    @ResponseBody ModelAndView home() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("message", "Hello Java Clazz");
        LOGGER.info("Da truy cap vao day");
        return mv;
    }

    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model){
        if (error != null) model.addAttribute("error","Sai tên hoặc mật khẩu!");
        return "login";
    }

    @RequestMapping(value = "/nguoi-dung")
    public String forUser(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("message","Hello User " + auth.getName());
        return "index";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request,response,auth);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/layout")
    public String layout() {
        return "layout";
    }

}
