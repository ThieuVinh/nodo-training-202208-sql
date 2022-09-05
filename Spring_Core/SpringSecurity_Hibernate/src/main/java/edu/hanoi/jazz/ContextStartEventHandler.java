package edu.hanoi.jazz;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContextStartEventHandler implements ApplicationListener<ContextStartedEvent> {

    private final static Logger LOGGER = Logger.getLogger(ContextStartEventHandler.class);

    @Autowired
    private DataSource dataSource;

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        LOGGER.info("context start application " + dataSource);
        try {
            createTable("HN_USER", "create table HN_USER\n" +
                    "(\n" +
                    "\tusername varchar(100) primary key not null,\n" +
                    " password varchar(100)," +
                    " email varchar(100)," +
                    " age int," +
                    " groupId int," +
                    " CONSTRAINT hn_user_ibfk_1 foreign key (groupId) references hn_group(id)\n" +
                    ")\n");
        } catch (Exception e) {
            LOGGER.error(e, e);
        }
    }

    private void createTable(String name, String script) throws SQLException {
        DatabaseMetaData dbms = dataSource.getConnection().getMetaData();
        ResultSet rs = dbms.getTables(null, null, name, null);
        if (rs.next()) {
            LOGGER.info("Table " + rs.getString("TABLE_NAME") + " already exists !");
            return;
        }
        dataSource.getConnection().createStatement().executeUpdate(script);
        LOGGER.info("Create success!");
    }
}

