package unit12;

import java.io.File;
import java.sql.*;

public class JdbcFirstExample {

    static Connection conn = null;
    static Statement statement = null;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {
            try {
                Class.forName("oracle.jdbc.OracleDriver");
                conn = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
                statement = conn.createStatement();
                System.out.println("Connect database successful!");

                String sql = "CREATE TABLE VINHTQ198_STUDENT (" +
                        "ID NUMBER(2) NOT NULL CONSTRAINT PK_STUDENT_VINHTQ198 PRIMARY KEY, " +
                        "NAME VARCHAR2(50), " +
                        "AGE  NUMBER(2)" +
                        ")";
                boolean resul = statement.execute(sql);
                System.out.println(resul);

                String sql2 = "CREATE SEQUENCE SEQ_STUDENT_VINHTQ198 INCREMENT BY 1 START WITH 1 NOCYCLE";
                System.out.println(statement.execute(sql2));
                System.out.println("Tạo bảng thành công");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Tạo bảng thất bại");
            }

        } finally {
            statement.close();
            conn.close();
        }
    }

}
