package xyz.cym2018.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import xyz.cym2018.DAO.User;

import java.util.List;

@SuppressWarnings("unused")
@Service
public class UserService extends TService<User> {
    static private Logger logger = LogManager.getLogger(UserService.class);

    UserService() {
    }

    public boolean Register(User user) {
        return Creat(user);
    }

    public User Login(User user) {
        HQL = "from xyz.cym2018.DAO.User where username=?1 and password=?2";
        values = new Object[]{user.getUsername(), user.getPassword()};
        return QueryObject();
    }

    public List QueryShopList() {
        HQL = "from xyz.cym2018.DAO.User where type='2'";
        values = new Object[]{};
        return QueryList();
    }

    public List QueryByShopOwner(int userId) {
        HQL = "from xyz.cym2018.DAO.User where belong=?1";
        values = new Object[]{userId};
        return QueryList();
    }

    public User QueryByUserID(int userId) {

        HQL = "from xyz.cym2018.DAO.User where userid=?1";
        values = new Object[]{userId};
        return QueryObject();

    }

    public User QueryByUsername(String username) {
        HQL = "from xyz.cym2018.DAO.User where username=?1";
        values = new String[]{username};
        return QueryObject();
    }
}
