package unit12;

import java.sql.*;

public class TransactionExample {
    static Connection conn = null;
    static Statement statement = null;

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            statement = conn.createStatement();

            conn.setAutoCommit(false);
            for (int i = 0; i < 10; i++) {
                String name = "DO TAT " + i;
                int age = 10 + i;
                PreparedStatement ps = conn.prepareStatement("INSERT INTO VINHTQ198_STUDENT VALUES (SEQ_STUDENT_VINHTQ198.nextval, ?, ?)");
                ps.setString(1, name);
                ps.setInt(2, age);
                ps.executeUpdate();
            }

            conn.rollback();
            conn.setAutoCommit(true);
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
