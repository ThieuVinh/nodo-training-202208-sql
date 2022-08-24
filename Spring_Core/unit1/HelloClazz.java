package unit1;

import org.springframework.beans.factory.DisposableBean;

import java.util.List;

public class HelloClazz implements DisposableBean {
    private String message;

    private List<JavaClazz> clazzes;

    public void setMessage(String message) {
        this.message = "Call From Setter: " + message;
    }

    public String getMessage() {
        return message;
    }

    public void printMessage() {
        System.out.println("Your message: " + message);
    }

    public void initMessage() {
        System.out.println("Calling init method....");
        message = "From init method: Say hello bean!";
    }

    public HelloClazz() {
        this.message = "From constructor: Say hello everyone !";
    }

    public void release() {
        message = null;
        System.out.println("Message is null");
    }

    @Override
    public void destroy() throws Exception {
        message = null;
        System.out.println("Message is null");
    }

    public HelloClazz(int person) {
        message = "From Constructor: Say hello to " + person + " person(s)!";
    }
}
