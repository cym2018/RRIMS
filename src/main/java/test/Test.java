package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import xyz.cym2018.DAO.Base;
import xyz.cym2018.DAO.User;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

public class Test {

    private Logger logger = LogManager.getLogger(Test.class);
//    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

    public static void main(String[] args) {
//        Test test = new Test();
//        test.Hibernate();
//        test.String();
//        test.Spring();
        HibernateTest();

    }

    @SuppressWarnings("JpaQlInspection")
    private static void HibernateTest(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Session session= Base.getSession();
        Query query=session.createQuery("from xyz.cym2018.DAO.Order");
        List result=query.getResultList();
        System.out.println(result.get(0).toString());

    }
    @Transactional
    void Hibernate() {
        try {
            Session session = Base.getSession();
            session.beginTransaction();
            session.save(new User("root3", "ab370126"));
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("插入失败");
            return;
        }
        System.out.println("插入成功");
    }

    void String() {
        String[] test = {"字符串1", "字符串2", "字符串3", "字符串4"};
        String test2 = Arrays.toString(test);
        test2 = test2.substring(1, test2.length() - 1);
        test = test2.split(", ");
        for (String i : test) {
            System.out.println(i);
        }
    }

    private void Spring() {
//        ac = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");

//        System.out.println("123");
//        logger.info("获取Bean abc");
//        Bean1 b1 = (Bean1) ac.getBean("Bean1");
//        System.out.println(b1.getName());
//        b1.setName("123");
//        logger.info("获取ApplicationContext");
//        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        logger.info("获取Bean abc");
//        b1 = (Bean1) ac.getBean("Bean1");
//        System.out.println(b1.getName());
    }


    // 代码实现数据库访问
    void code() {
        DriverManagerDataSource dmds = new DriverManagerDataSource();
        dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dmds.setUrl("jdbc:mysql://localhost:3306/RRIMS?serverTimezone=CST");
        dmds.setUsername("root");
        dmds.setPassword("ab370126");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dmds);
        jdbcTemplate.update("insert into test values (1)");
    }

    // xml+代码实现数据库访问
    void xml() {
//        DriverManagerDataSource dmds = (DriverManagerDataSource) ac.getBean("dataSource");
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dmds);
//        jdbcTemplate.update("insert into test values (2)");
    }

    // 纯xml实现数据库访问
    void xml2() {
//        JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
//        jt.update("insert into test values (9)");
    }

    public void log() {
        logger.trace("trace");
        logger.info("info");
        logger.debug("debug");
        logger.warn("warn");
        logger.error("error");
        logger.fatal("fatal");
    }
}
