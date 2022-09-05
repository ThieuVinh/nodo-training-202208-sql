package edu.hanoi.jazz.controller;

import edu.hanoi.jazz.dao.GroupDAO;
import edu.hanoi.jazz.dao.UserDAO;
import edu.hanoi.jazz.model.Group;
import edu.hanoi.jazz.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    private static Logger LOGGER = Logger.getLogger(UserController.class);

    @Autowired
    private GroupDAO groupDAO;

    @Autowired
    private UserDAO userDAO;

    @GetMapping(value = "/add")
    public ModelAndView addForm() {
        ModelAndView mv = new ModelAndView("user.form", "command", new User());
        mv.addObject("groups", toGroupMap(groupDAO.list(null)));
        return mv;
    }

    private Object toGroupMap(List<Group> groups) {
        Map<Integer, String> map = new HashMap<>();
        groups.forEach(group -> {
            map.put(group.getId(), group.getName());
        });
        return map;
    }

    @PostMapping(value = "save")
    public ModelAndView addNew(@Valid @ModelAttribute("command") User user, BindingResult result) {
        ModelAndView model;
        if (result.hasErrors()) {
            model = new ModelAndView("user.form", "command", user);
            model.addObject("errors", result);
            return model;
        }
        userDAO.insert(user);
        LOGGER.info("add new user --> " + user);
        return new ModelAndView("redirect:/user/list");
    }

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "group", required = false) Integer group) {
        ModelAndView mv = new ModelAndView("user.list");
        mv.addObject("users", userDAO.list(group));
        return mv;
    }

    @GetMapping(value = "/delete/{username}")
    public ModelAndView delete(@PathVariable("username") String username) {
        if (username == null) {
            return new ModelAndView("redirect:/user/list");
        }
        userDAO.delete(username);
        return new ModelAndView("redirect:/user/list");
    }

    @GetMapping(value = "/detail/{username}")
    public ModelAndView listDetail(@PathVariable("username") String username) {
        ModelAndView mv = new ModelAndView("user.detail");
        mv.addObject("users", userDAO.get(username));
        return mv;
    }
}
