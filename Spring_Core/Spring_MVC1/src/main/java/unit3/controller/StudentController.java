package unit3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import unit3.model.Student;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {

//    @GetMapping(value = "/add")
//    public ModelAndView add() {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("student/form");
//        return mv;
//    }

//    @PostMapping(value = "/save")
//    public ModelAndView save(@RequestParam(value = "name", required = false) String name,
//                             @RequestParam(value = "age", required = false) int age) {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("student/view");
//        mv.addObject("name", name);
//        mv.addObject("age", age);
//        return mv;
//    }

    @GetMapping(value = "/add")
    public ModelAndView add() {
        return new ModelAndView("/student/form", "command", new Student());
    }

    @PostMapping(value = "/save")
    public ModelAndView save(@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "age", required = false) int age,
                             @Valid @ModelAttribute("command") Student students, BindingResult result) {
        Student student = new Student(name, age);
        ModelAndView mv = new ModelAndView();
        if (result.hasErrors()) {
            mv = new ModelAndView("student/form", "command", students);
            mv.addObject("errors", result);
            return mv;
        }
        mv.setViewName("student/view");
        mv.addObject("student", student);
        return mv;
    }


//
//    @PostMapping(value = "/save")
//    public ModelAndView save(Student student) {
//        Student student1 = new Student();
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("student/view");
//        mv.addObject("student", student1);
//        return mv;
//    }

}
