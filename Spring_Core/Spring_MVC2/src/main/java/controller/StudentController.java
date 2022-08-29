package controller;

import dao.StudentDAO;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Optional;


@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentDAO studentDAO;

    @GetMapping(value = "/add")
    public ModelAndView add() {
        return new ModelAndView("student/form", "command", new Student());
    }

    @PostMapping(value = "/save")
    public ModelAndView save(@Valid @ModelAttribute("command") Student student, BindingResult result) {
        ModelAndView mv;
        if (result.hasErrors()) {
            mv = new ModelAndView("student/form", "command", student);
            mv.setViewName("student/form");
            mv.addObject("errors", result);
            return mv;
        }
        if (student.getId() > 0) {
            studentDAO.update(student);
        } else {
            studentDAO.insert(student);
        }
        return new ModelAndView("redirect:/student/list");
    }

    @GetMapping(value = "/list")
    public ModelAndView listStudent(@RequestParam("q") Optional<String> query) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("student/listStudent");
        if (!query.isPresent()) {
            mv.addObject("students", studentDAO.list());
        }
        if (query.isPresent()) {
            mv.addObject("students", studentDAO.search(query.get()));
        }
        return mv;
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        studentDAO.delete(id);
        return "redirect:/student/list";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {
        Student student = studentDAO.get(id);
        return new ModelAndView("student/form", "command", student);
    }

    @GetMapping(value = "/json/{id}")
    public @ResponseBody Student viewJson(@PathVariable("id") Integer id) {
        return studentDAO.get(id);
    }

//    @GetMapping(value = "/")
//    public String home() {
//        return "redirect:/student/list";
//    }

    @RequestMapping(value = "/avatar/save/{id}", method = RequestMethod.POST)
    public String handlerFormUpload(@RequestParam("file") MultipartFile file,
                                    @PathVariable("id") Integer id,
                                    HttpServletRequest request) throws IOException {
        if (file.isEmpty()) return "student/error";

        byte[] bytes = file.getBytes();
        System.out.println("found ---> " + bytes.length);
        Path avatarFile = getImageFile(request, id);
        Files.write(avatarFile, file.getBytes(), StandardOpenOption.CREATE);

        System.out.println(avatarFile);
        return "redirect:/student/list";
    }

    private Path getImageFile(HttpServletRequest request, Integer id) {
        ServletContext servletContext = request.getSession().getServletContext();
        String realPath = servletContext.getRealPath("/");
        File folder = new File(realPath + File.separator + "avatar");
        if (!folder.exists()) folder.mkdirs();
        return Path.of(String.valueOf(folder), String.valueOf(id) + ".jpg");
    }

    @RequestMapping(value = "/avatar/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Integer id, HttpServletRequest request) throws IOException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        if (id != null) {
            Path avatarPath = getImageFile(request, id);
            byteOut.write(Files.readAllBytes(avatarPath));
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(byteOut.toByteArray(), headers, HttpStatus.CREATED);
    }
}
