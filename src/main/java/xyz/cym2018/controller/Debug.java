package xyz.cym2018.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.cym2018.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/debug")
public class Debug {
    @Autowired
    UserService userService;
    @RequestMapping("/userlist")
    public ModelAndView userList(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        List user = userService.SelectAllUser();
        modelAndView.addObject("user", user);
        modelAndView.addObject("test", "test");
        modelAndView.setViewName("debug/userlist");
        return modelAndView;
    }
}
