package unit1;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        Example5();
    }

    public static void Example1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloClazz obj = (HelloClazz) context.getBean("helloJavaClazz");
        obj.printMessage();


    }

    public static void Example2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloClazz obj = (HelloClazz) context.getBean("helloJavaClazz");
        obj.printMessage();
        System.out.println(obj);

        HelloClazz obj2 = (HelloClazz) context.getBean("helloJavaClazz");
        obj2.printMessage();
        System.out.println(obj2 == obj2);
    }

    public static void Example3() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.registerShutdownHook();
    }

    public static void Example4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.sayHello();
    }

    public static void Example5() {
        Logger LOGGER = Logger.getLogger(JavaClazz.class);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        JavaClazz clazz = (JavaClazz) context.getBean("jee01");
        LOGGER.info("Map Implement is " + clazz.getStudents().getClass());
        LOGGER.info("There are " + clazz.getStudents().size() + " in the class");
    }
}
