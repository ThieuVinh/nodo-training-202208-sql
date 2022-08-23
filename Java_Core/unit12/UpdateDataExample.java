package unit12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class UpdateDataExample {
    static Connection conn = null;
    static Statement statement = null;

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            statement = conn.createStatement();

            PreparedStatement ps = conn.prepareStatement("UPDATE VINHTQ198_STUDENT SET NAME = ? WHERE ID = ?");
            ps.setString(1, "THIEU VINH");
            ps.setInt(2, 2);

            ps.executeUpdate();
            System.out.println("Cập nhật thành công");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
