package unit2;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.Loader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class JdbcApp {

    private static final Logger LOGGER = Logger.getLogger(JdbcApp.class);

    public static void main(String[] args) {
        save();
    }

    public static void CreateTable() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentJdbcDAO jdbc = (StudentJdbcDAO) context.getBean("studentJdbcDAO");
        LOGGER.info(" created bean " + jdbc);
    }

    public static void Insert() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentJdbcDAO jdbc = (StudentJdbcDAO) context.getBean("studentJdbcDAO");
        jdbc.insert("Thieu Quang Vinh", 20);
    }

    public static void TotalRecord() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentJdbcDAO jdbc = (StudentJdbcDAO) context.getBean("studentJdbcDAO");
        LOGGER.info("Total students is " + jdbc.totalRecord());
    }

    public static void LoadStudent() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentJdbcDAO jdbc = (StudentJdbcDAO) context.getBean("studentJdbcDAO");
        jdbc.loadStudent("Vinh").forEach(student -> {
            LOGGER.info(student);
        });
    }

    public static void BatchProcessing() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentJdbcDAO jdbc = (StudentJdbcDAO) context.getBean("studentJdbcDAO");

        List<Student> students = new ArrayList<>();
        students.add(new Student("Nguyen Hong Son", 19));
        students.add(new Student("Do Tat Hoa", 18));
        students.add(new Student("Truong Thi Van Tu", 17));

        int[] values = jdbc.add(students);
        for (int i = 0; i < values.length; i++) {
            LOGGER.info("add record " + i + " : " + (values[i] == 0 ? "failed" : "success"));
        }
        LOGGER.info("Total students is " + jdbc.totalRecord());
    }

    public static void save() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentJdbcDAO jdbc = (StudentJdbcDAO) context.getBean("studentJdbcDAO");
        jdbc.save("Le Van Cuong" , 12);
    }

}
