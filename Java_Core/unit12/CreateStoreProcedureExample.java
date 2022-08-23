package unit12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateStoreProcedureExample {

    static Connection conn = null;
    static Statement statement = null;

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            statement = conn.createStatement();

            statement.executeUpdate("CREATE PROCEDURE GETAGE(STR_NAME VARCHAR2(225), OUT AGE NUMBER(2))" +
                    "PARAMETER STYLE JAVA READS" +
                    "SQL DATA LANGUAGE JAVA EXTERNAL NAME" +
                    "'jdbc.DbFunction.getAge'");
            System.out.println("done");

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
