package controller;

import dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import model.JavaClazz;
import org.springframework.web.servlet.ModelAndView;
import utils.XSLUtils;

@Controller
@RequestMapping(value = "clazz")
public class ClazzController {

    @Autowired
    private StudentDAO studentDAO;

    @GetMapping(value = "/xml", produces = {MediaType.APPLICATION_XML_VALUE})
    public @ResponseBody JavaClazz viewInXML() {
        return new JavaClazz(studentDAO.list());
    }

    @GetMapping(value = "/json", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody JavaClazz viewInJson() {
        return new JavaClazz(studentDAO.list());
    }

    @GetMapping(value = "/xslt")
    public ModelAndView viewXSLT() throws Exception {
        JavaClazz clazz = new JavaClazz();
        ModelAndView model = new ModelAndView("ClazzView");
        model.getModelMap().put("data", XSLUtils.clazzToDomSource(clazz));
        return model;
    }

    @GetMapping(value = "excel")
    public ModelAndView viewExcel() {
        JavaClazz clazz = new JavaClazz();
        ModelAndView model = new ModelAndView("excelView");
        model.getModelMap().put("clazzObj",clazz);
        return model;
    }
}
