package xyz.cym2018.DAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.Test;
import xyz.cym2018.tools.Beans;

@Component("Base")
public class Base {
    static private SessionFactory sessionFactory;

    private Logger logger = LogManager.getLogger(Base.class);

    Base() {
        logger.info("Base(0)");
    }

    @Autowired
    Base(SessionFactory sessionFactory) {
        logger.info("Base(1)");
        Base.sessionFactory = sessionFactory;
        Test test=new Test();
        test.log();
    }


    public static Session getSession() {
        if (sessionFactory == null) {
            System.out.println("sessionFactory is null");
            sessionFactory = (SessionFactory) Beans.getBean("sessionFactory");
        }
        // todo:改为getCurrentSession()
        return sessionFactory.openSession();
    }
}
