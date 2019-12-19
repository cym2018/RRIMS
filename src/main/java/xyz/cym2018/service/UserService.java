package xyz.cym2018.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import xyz.cym2018.DAO.Base;
import xyz.cym2018.DAO.User;
import xyz.cym2018.tools.Beans;

import java.util.List;

@Service
public class UserService {
    private Logger logger = LogManager.getLogger(UserService.class);

    UserService() {
        logger.info("UserService(0)");
    }

    public static boolean Register(String username, String password) {
        User user = (User) Beans.getBean("User");
        user.setUsername(username);
        user.setPassword(password);
        Session session = Base.getSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean Register(User user) {
        Session session = Base.getSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public static List SelectAll(){
        Session session = Base.getSession();
        return session.createQuery("from xyz.cym2018.DAO.User").list();
    }

}
