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
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    HttpSession session;
    @Autowired
    HttpServletRequest request;
    private Logger logger = LogManager.getLogger(UserController.class);

    UserController() {
        logger.info("UserController(0)");
    }

    @RequestMapping("/info")
    public ModelAndView Info() {
        int iUserID;
        ModelAndView modelAndView = new ModelAndView("user/info");
        // 获取用户id
        try {
            iUserID = Integer.parseInt(session.getAttribute("userID").toString());
        } catch (Exception e) {
            return modelAndView;
        }
        // 查询用户信息
        User uUser = userService.findByUserID(iUserID);
        modelAndView.addObject("userInfo", uUser);
        // 查询店铺信息
        List Shop = userService.findByBelong(uUser.getUserid());
        modelAndView.addObject("shopInfo", Shop);
        return modelAndView;
    }


}
