package unit7.IO;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchFileNIOExample {
    public static void main(String[] args) throws Exception {
        Charset charset = Charset.forName("utf8");
        Pattern pattern = Pattern.compile("s\\S", Pattern.CASE_INSENSITIVE);

        File file = new File("D:\\Temp2\\test1\\io_sample.txt");
        FileInputStream stream = new FileInputStream(file);
        FileChannel channel = stream.getChannel();
        ByteBuffer bytes = channel.map(
                FileChannel.MapMode.READ_ONLY, 0, channel.size());
        CharBuffer chars = charset.decode(bytes);
        Matcher matcher = pattern.matcher(chars);

        if (file.isFile()) {
            System.out.println("Found at " + Integer.toString(matcher.start()));
            System.out.println("Value " + chars.subSequence(0, 9));
        } else {
            System.out.println("Not found !");
        }

    }
}
