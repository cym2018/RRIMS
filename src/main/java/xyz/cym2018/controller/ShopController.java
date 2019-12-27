package xyz.cym2018.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.cym2018.DAO.User;
import xyz.cym2018.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/shop")
@Controller
public class ShopController {
    @Autowired
    HttpSession session;
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/creat")
    public ModelAndView Creat(User user) {
        int iUserID;
        ModelAndView modelAndView = new ModelAndView("info");
        // 设置用户类型:店铺
        user.setType(2);
        // 设置创建者id
        iUserID = Integer.parseInt(session.getAttribute("userID").toString());
        user.setBelong(iUserID);
        // 注册店铺
        try {
            UserService.Register(user);
            modelAndView.addObject("message", "创建成功");
        } catch (Exception e) {
            modelAndView.addObject("message", "店铺名已存在");
            modelAndView.addObject("url", request.getRequestURI() + ".jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/info")
    public ModelAndView Info(int id) {
        ModelAndView modelAndView = new ModelAndView("shop/info");
        User shop = UserService.findByUserID(id);
        session.setAttribute("shopID", id);
        modelAndView.addObject("shopInfo", shop);
        return modelAndView;
    }

    @RequestMapping("/menu")
    public ModelAndView Menu() {
        ModelAndView modelAndView = new ModelAndView("info");
        // 获取用户id和店铺id
        int shopID = Integer.parseInt(session.getAttribute("shopID").toString());
        int userId = Integer.parseInt(session.getAttribute("userID").toString());
        // 验证权限
        User shop = UserService.findByUserID(shopID);
        if (shop.getBelong() != userId) {
            // 无权限
            modelAndView.addObject("message", "操作失败,无权访问");
            return modelAndView;
        }
        // todo:查询菜单并显示
        return null;
    }
}
