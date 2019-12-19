package xyz.cym2018.DAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
    private Logger logger = LogManager.getLogger(User.class);
    private int id;
    private String username, password;

    public User() {
        logger.info("User(0)");
    }

    public User(String username, String password) {
        logger.info("User(2)");
        this.username = username;
        this.password = password;
    }
    public User(int id, String username, String password) {
        logger.info("User(3)");
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @GeneratedValue(generator = "increment")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "id:"+id+" username:"+username+" password:"+password;
    }
}
