package unit2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThrowableExample {
    public static void main(String[] args) {
        try {
            System.out.println("number = " + toNumber("sơn"));
        } catch (SaiSoException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
    }

    private static int toNumber(String value) throws SaiSoException {
        try {
            Integer integer = Integer.parseInt(value);
            return integer.intValue();
        } catch (NumberFormatException e) {
            throw new SaiSoException(value);
        }
    }

    private final static Logger LOGGER = Logger.getLogger(ThrowableExample.class.getName());
}
