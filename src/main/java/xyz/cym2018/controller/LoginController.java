package xyz.cym2018.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.cym2018.DAO.User;
import xyz.cym2018.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    HttpSession session;
    @Autowired
    HttpServletRequest request;
    private Logger logger = LogManager.getLogger(LoginController.class);

    LoginController() {
        logger.info("LoginController(0)");
    }

    @RequestMapping("/register")
    public ModelAndView register(User user) {
        ModelAndView modelAndView = new ModelAndView("info");
        // 注册
        if (userService.Register(user)) {
            modelAndView.addObject("message", "注册成功");
        } else {
            modelAndView.addObject("message", "用户名已存在");
            modelAndView.addObject("url", request.getRequestURI() + ".jsp");
        }

        return modelAndView;
    }

    @RequestMapping("/login")
    public ModelAndView login(User user) {
        ModelAndView modelAndView = new ModelAndView("info");

        // 登陆验证
        if (userService.Login(user)) {
            // 获取用户信息&保存
            user = userService.findByUsername(user.getUsername());
            session.setAttribute("userID", user.getUserid());
            session.setAttribute("username", user.getUsername());
            modelAndView.addObject("message", "登陆成功");
        } else {
            modelAndView.addObject("message", "用户名或密码不正确");
            modelAndView.addObject("url", request.getRequestURI() + ".jsp");
        }

        return modelAndView;
    }
}
