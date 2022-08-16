package unit2;

public class SaiSoException extends Exception {
    private String so;

    public SaiSoException(String value) {
        this.so = value;
    }

    public String getMessage() {
        return "Giá trị " + so + " không phải là số !!";
    }
}
