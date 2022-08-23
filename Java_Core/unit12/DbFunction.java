package unit12;

import java.sql.*;

public class DbFunction {
    static Connection conn = null;
    static Statement statement = null;

    public static void main(String[] args) throws SQLException {
        int[] ages = new int[1];
        getAge("THIEU VINH", ages);
        System.out.println(ages[0]);
    }

    public static void getAge(String name, int[] ages) throws SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT MAX(AGE) FROM VINHTQ198_STUDENT WHERE NAME LIKE '%" + name + "%'");
            ages[0] = rs.next() ? rs.getInt(1) : -1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }
}
