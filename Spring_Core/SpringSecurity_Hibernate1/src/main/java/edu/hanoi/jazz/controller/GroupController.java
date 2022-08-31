package edu.hanoi.jazz.controller;

import edu.hanoi.jazz.dao.GroupDAO;
import edu.hanoi.jazz.model.Group;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "/group")
public class GroupController {
    private static Logger LOGGER = Logger.getLogger(GroupController.class);

    @Autowired
    private GroupDAO groupDAO;

    @GetMapping(value = "/add")
    public ModelAndView addForm() {
        return new ModelAndView("group.form", "command", new Group());
    }

    @PostMapping(value = "/save")
    public ModelAndView addNew(@Valid @ModelAttribute("command") Group group, BindingResult result) {
        ModelAndView model;
        if (result.hasErrors()) {
            model = new ModelAndView("group.form", "command", group);
            model.addObject("errors", result);
            return model;
        }
        if (group.getId() > 0) {
            groupDAO.update(group);
        } else {
            groupDAO.insert(group);
        }
        LOGGER.info("add new group --> " + group);
        return new ModelAndView("redirect:/group/list");
    }

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "q", required = false) String pattem) {
        ModelAndView mv = new ModelAndView("group.list");
        mv.addObject("groups", groupDAO.list(pattem));
        return mv;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {
        if (id == null) {
            return new ModelAndView("redirect:/group/list");
        }
        groupDAO.delete(id);
        return new ModelAndView("redirect:/group/list");
    }

    @GetMapping(value = "/update")
    public ModelAndView updateForm(@RequestParam(value = "id", required = true) Integer id) {
        Group group = groupDAO.get(id);
        if (group == null) {
            return new  ModelAndView("redirect:/group/list");
        }
        return new ModelAndView("group.form", "command", group);
    }
}
