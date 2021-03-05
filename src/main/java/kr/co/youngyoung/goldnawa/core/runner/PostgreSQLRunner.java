package kr.co.youngyoung.goldnawa.core.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class PostgreSQLRunner implements ApplicationRunner {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Logger logger = LoggerFactory.getLogger(getClass());

        Connection connection = dataSource.getConnection();
        logger.info("Url: " + connection.getMetaData().getURL());
        logger.info("UserName: " + connection.getMetaData().getUserName());

        /*try (Connection connection = dataSource.getConnection()){
            System.out.println(dataSource.getClass());
            System.out.println(connection.getMetaData().getURL());
            System.out.println(connection.getMetaData().getUserName());

            Statement statement = connection.createStatement();
            String sql = "select 1";
            statement.executeUpdate(sql);
        }*/
        /*jdbcTemplate.queryForRowSet("select 3");*/
    }
}