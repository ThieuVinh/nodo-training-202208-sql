package unit7.IO;

import java.io.*;

public class ObjectWriterExample {
    public static void main(String[] args) {
        File folder = new File("D:\\Temp\\");
        ObjectOutputStream output = null;
        try {
            FileOutputStream fileOutput = new FileOutputStream(new File(folder, "my_object"));
            output = new ObjectOutputStream(fileOutput);
            PrintMessage printMessage = new PrintMessage("Can Noi Noi");
            output.writeObject(printMessage);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
