package xyz.cym2018.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class SpringJDBCTest {
    static Logger logger = LogManager.getLogger(SpringJDBCTest.class);
    private static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

    public static void main(String[] args) {
//        xml();
//        code();
        xml2();
    }

    // 代码实现数据库访问
    public static void code() {
        DriverManagerDataSource dmds = new DriverManagerDataSource();
        dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dmds.setUrl("jdbc:mysql://localhost:3306/RRIMS?serverTimezone=CST");
        dmds.setUsername("root");
        dmds.setPassword("ab370126");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dmds);
        jdbcTemplate.update("insert into test values (1)");
    }

    // xml+代码实现数据库访问
    public static void xml() {
        DriverManagerDataSource dmds = (DriverManagerDataSource) ac.getBean("dataSource");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dmds);
        jdbcTemplate.update("insert into test values (2)");
    }

    // 纯xml实现数据库访问
    private static void xml2() {
        JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
        jt.update("insert into test values (8)");
        ac.getBean("abc");
    }
}
