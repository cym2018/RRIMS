package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("Bean1")
public class Bean1 {
    private static Logger logger = LogManager.getLogger(Bean1.class);
    private static Bean1 bean1 = new Bean1();
    private String Name;

    @SuppressWarnings("WeakerAccess")
    Bean1() {
        Name = "Bean1";
        logger.info("Bean1(0)");
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


}
