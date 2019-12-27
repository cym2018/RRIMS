package xyz.cym2018.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import xyz.cym2018.DAO.Base;
import xyz.cym2018.DAO.User;
import xyz.cym2018.tools.Beans;

import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Service
public class UserService {
    private Logger logger = LogManager.getLogger(UserService.class);

    UserService() {
        logger.info("UserService(0)");
    }

    public boolean Register(String username, String password) {
        User user = (User) Beans.getBean("User");
        user.setUsername(username);
        user.setPassword(password);
        return Register(user);
    }

    public boolean Register(User user) {
        try (Session session = Base.getSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean Login(String username, String password) {
        User user = (User) Beans.getBean("User");
        user.setUsername(username);
        user.setPassword(password);
        return Login(user);
    }


    public boolean Login(User user) {
        if (user.getUsername() == null || user.getPassword() == null) {
            return false;
        }

        String hql = "from xyz.cym2018.DAO.User where username=?1 and password=?2";
        try (Session session = Base.getSession()) {
            Query query = session.createQuery(hql);
            query.setParameter(1, user.getUsername());
            query.setParameter(2, user.getPassword());
            return !query.list().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public List SelectAll() {
        Session session = Base.getSession();
        return session.createQuery("from xyz.cym2018.DAO.User").list();
    }

    public List SelectAllUser() {
        Session session = Base.getSession();
        return session.createQuery("from xyz.cym2018.DAO.User where type!='2'").list();
    }

    public List SelectShopById(int id) {
        Session session = Base.getSession();
        String hql = "from xyz.cym2018.DAO.User where belong=?1";
        Query query = session.createQuery(hql);
        query.setParameter(1, id);
        return query.list();
    }

    public User findByUserID(int id) {
        Session session = Base.getSession();
        String hql = "from xyz.cym2018.DAO.User where userid=?1";
        Query query = session.createQuery(hql);
        query.setParameter(1, id);
        return (User) query.list().get(0);
    }

    public User findByUsername(String username) {
        Session session = Base.getSession();
        String hql = "from xyz.cym2018.DAO.User where username=?1";
        Query query = session.createQuery(hql);
        query.setParameter(1, username);
        return (User) query.list().get(0);
    }

    public List findByBelong(int belong) {
        Session session = Base.getSession();
        String hql = "from xyz.cym2018.DAO.User where belong=?1";
        Query query = session.createQuery(hql);
        query.setParameter(1, belong);
        return query.list();
    }


}
