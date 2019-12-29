package xyz.cym2018.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.cym2018.DAO.User;
import xyz.cym2018.service.UserService;

@SuppressWarnings({"SpringJavaAutowiredFieldsWarningInspection", "unused"})
@Controller
public class RootController extends SessionOperate {
    @Autowired
    UserService userService;

    private Logger logger = LogManager.getLogger(RootController.class);


    @RequestMapping("/register")
    public ModelAndView register(User userInfo) {
        ModelAndView modelAndView = new ModelAndView("message");
        modelAndView.addObject("message", userService.Register(userInfo) ? "注册成功" : "注册失败");
        return modelAndView;
    }

    @RequestMapping("/login")
    public ModelAndView login(User user) {
        ModelAndView modelAndView = new ModelAndView("message");
        User userInfo = userService.Login(user);
        if (userInfo == null) {
            modelAndView.addObject("message", "登陆失败:用户名或密码不正确");
        } else {
            setUserId(userInfo.getUserid());
            modelAndView.addObject("message", "登陆成功");
        }
        return modelAndView;
    }
}
