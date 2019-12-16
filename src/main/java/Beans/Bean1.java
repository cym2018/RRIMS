package Beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
public class Bean1 {
    static Logger logger= LogManager.getLogger(Bean1.class);
    private static Bean1 bean1 = new Bean1();
    private String Name = "BeanTest";
    Bean1() {
        logger.debug("创建Bean1");
    }
    static Bean1 creat() {
        logger.info("获取Bean1");
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
