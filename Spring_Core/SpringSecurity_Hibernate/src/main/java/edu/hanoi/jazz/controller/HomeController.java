package edu.hanoi.jazz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("message", "Hello Jazz Clazz");
        return mv;
    }

    @RequestMapping(value = "/nguoi-dung")
    public ModelAndView forUser() {
        ModelAndView model = new ModelAndView();
        model.addObject("message", "This is protected page !");
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/dang-nhap")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Sai tên hoặc mật khẩu!");
        }
        return "login";
    }
}
