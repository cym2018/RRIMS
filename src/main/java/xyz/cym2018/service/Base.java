package xyz.cym2018.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.cym2018.tools.Beans;

@SuppressWarnings({"SpringJavaAutowiredFieldsWarningInspection", "unused"})
@Component
public class Base {
    @Autowired
    static private SessionFactory sessionFactory;

    private Logger logger = LogManager.getLogger(Base.class);

    Base() {

    }


    Session getSession() {
        if (sessionFactory == null) {
            sessionFactory = (SessionFactory) Beans.getBean("sessionFactory");
        }
        // todo:改为getCurrentSession()
        return sessionFactory.openSession();
    }
}
