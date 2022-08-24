package unit1;

import org.apache.log4j.Logger;

public class HelloWorld {
    private final static Logger LOGGER = Logger.getLogger(HelloWorld.class);
    private String message;

    private HelloClazz clazz;

    public HelloWorld() {

    }

    public void sayHello() {
        clazz.printMessage();
        LOGGER.info("From HelloWorld: " + message);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HelloWorld(String name, HelloClazz clazz) {
        message = "From HelloWorld constructor: " + name + " : " + clazz.getMessage();
    }

    public void setClazz(String clazz) {
    }
}
