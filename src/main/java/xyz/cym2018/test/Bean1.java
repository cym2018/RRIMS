package xyz.cym2018.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Bean1 {
    static Logger logger = LogManager.getLogger(Bean1.class);

    // 静态存储对象
    private static Bean1 bean1 = new Bean1();

    private String Name = "BeanTest";

    Bean1() {
        logger.info("Bean1()");
    }

    static Bean1 creat() {
        logger.info("creat()");
        return bean1;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return Name;
    }

}
