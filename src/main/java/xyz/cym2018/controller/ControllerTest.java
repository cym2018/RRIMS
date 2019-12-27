package xyz.cym2018.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import test.Bean1;
import xyz.cym2018.tools.Beans;

@Controller
public class ControllerTest {
    private static Logger logger = LogManager.getLogger(ControllerTest.class);
    private String name;

    ControllerTest() {
        logger.info("ControllerTest(0)");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @RequestMapping("/runController")
    public String t1(Model model) {
        Bean1 b1 = (Bean1) Beans.getBean("User");
        return "info/success";
    }
}

