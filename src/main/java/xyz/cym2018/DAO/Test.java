package xyz.cym2018.DAO;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test {
    private Logger logger = LogManager.getLogger(Test.class);
    @Column(name = "id")
    private int id;

    Test() {
        logger.info("Test(0)");
    }


    Test(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
