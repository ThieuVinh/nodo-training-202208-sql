package unit12;

import java.sql.*;

public class JdbcMetadataExample {
    static Connection conn = null;
    static Statement statement = null;

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            statement = conn.createStatement();

            DatabaseMetaData metaData = conn.getMetaData();

            System.out.println("db version: " + metaData.getDatabaseMajorVersion());
            System.out.println("driver name: " + metaData.getDriverName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }
}
