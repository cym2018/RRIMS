package xyz.cym2018.mvc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest {
    static Logger logger = LogManager.getLogger(ControllerTest.class);
    private String name;

    ControllerTest() {
        logger.info("ControllerTest");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @RequestMapping("/ct")
    public String t1(Model model) {
        logger.info("调用");
        return "success";
    }
}

