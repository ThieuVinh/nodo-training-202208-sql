package unit12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BatchProcessingExample {
    static Connection conn = null;
    static Statement statement = null;

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            statement = conn.createStatement();

            for (int i = 0; i < 20; i++) {
                String name = "NGUYEN HONG SON " + i;
                int age = 20 + i;
                String sql = "INSERT INTO VINHTQ198_STUDENT VALUES " + "(" + "SEQ_STUDENT_VINHTQ198.nextval" + "," +
                                name + "," + age + ")";
                statement.addBatch(sql);
            }
            statement.executeBatch();

            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM VINHTQ198_STUDENT");
            if (rs.next()) {
                System.out.println("Total record = " + rs.getInt(1));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
