package xyz.cym2018.DAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(generator = "increment")
    private int userid;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private int type;
    @Column
    private int belong;

    public User() {
        Logger logger = LogManager.getLogger(User.class);
        logger.info("User(0)");
    }

    public User(String username, String password) {
        Logger logger = LogManager.getLogger(User.class);
        logger.info("User(2)");
        this.username = username;
        this.password = password;
    }

    public User(int userid, String username, String password) {
        Logger logger = LogManager.getLogger(User.class);
        logger.info("User(3)");
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    // 用户
    public User(int userid, String username, String password, int type) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    // 店铺
    public User(int userid, String username, int type, int belong) {
        this.userid = userid;
        this.username = username;
        this.type = type;
        this.belong = belong;
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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        if (type != 2) {
            return "userid:" + userid + " username:" + username + " password:" + password + " type:" + type;
        } else {
            return "userid:" + userid + " username:" + username + " type:" + type + " belong:" + belong;
        }
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getBelong() {
        Logger logger = LogManager.getLogger(User.class);
        if (this.type != 2) {
            logger.warn("用户不存在belong字段,错误对象:");
            logger.warn(toString());
        }
        return belong;
    }

    public void setBelong(int belong) {
        this.belong = belong;
    }
}
