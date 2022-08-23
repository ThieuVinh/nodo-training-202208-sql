package unit12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class InsertDataExample {
    static Connection conn = null;
    static Statement statement = null;

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            statement = conn.createStatement();

            statement.execute("INSERT INTO VINHTQ198_STUDENT VALUES (SEQ_STUDENT_VINHTQ198.nextval, 'THIEU QUANG VINH', 20)");
            statement.execute("INSERT INTO VINHTQ198_STUDENT VALUES (SEQ_STUDENT_VINHTQ198.nextval, 'DO TAT HOA', 20)");
            statement.execute("INSERT INTO VINHTQ198_STUDENT VALUES (SEQ_STUDENT_VINHTQ198.nextval, 'NGUYEN HONG SON', 20)");
            System.out.println("Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            statement.close();
            conn.close();
        }
    }
}
