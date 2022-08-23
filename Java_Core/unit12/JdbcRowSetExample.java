package unit12;


import javax.sql.rowset.JdbcRowSet;
import java.io.File;
import java.sql.SQLException;

public class JdbcRowSetExample {
    public static void main(String[] args) throws SQLException {
        JdbcRowSet jdbcRowSet = new JdbcRowSetImpl();
        File file = new File("sampledb");
        jdbcRowSet.setUrl("jdbc:derby:" + file);
        jdbcRowSet.setCommand("SELECT *");
        jdbcRowSet.execute();

        while (jdbcRowSet.next()) {
            System.out.println(jdbcRowSet.getInt(1) + "\t" + jdbcRowSet.getString("NAME"));
        }
        jdbcRowSet.close();
    }
}
