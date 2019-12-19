package xyz.cym2018.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.cym2018.DAO.User;
import xyz.cym2018.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private Logger logger = LogManager.getLogger(UserController.class);

    UserController() {
        logger.info("Register(0)");
    }

    @RequestMapping("/register")
    public String register(User user) {
        System.out.println(user.getUsername() + user.getPassword());
        if (UserService.Register(user)) {
            return "info/success";
        } else {
            return "info/failure";
        }
    }

    @RequestMapping("/userlist")
    public ModelAndView userList(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        List user = UserService.SelectAll();
        modelAndView.addObject("user", user);
        modelAndView.addObject("test", "test");
        modelAndView.setViewName("/user/userlist");
        return modelAndView;
    }
}
