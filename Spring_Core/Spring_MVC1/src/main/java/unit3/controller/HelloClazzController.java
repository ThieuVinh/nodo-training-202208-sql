package unit3.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloClazzController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printiMessage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("message", "Hello Java CLazz !");
        return mv;
    }
}
