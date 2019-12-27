package xyz.cym2018.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.cym2018.DAO.Goods;
import xyz.cym2018.DAO.User;
import xyz.cym2018.service.GoodsService;
import xyz.cym2018.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/shop")
@Controller
public class ShopController {
    Logger logger = LogManager.getLogger(ShopController.class);
    @Autowired
    GoodsService goodsService;
    @Autowired
    UserService userService;
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
            userService.Register(user);
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
        User shop = userService.findByUserID(id);
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
        User shop = userService.findByUserID(shopID);
        if (shop.getBelong() != userId) {
            // 无权限
            modelAndView.addObject("message", "操作失败,无权访问");
            return modelAndView;
        }
        List menu = goodsService.findByShopID(shopID);
        modelAndView.addObject("menu", menu);
        modelAndView.setViewName("shop/menu");
        return modelAndView;
    }

    @RequestMapping("/addgoods")
    public ModelAndView AddGoods(Goods goods) {
        ModelAndView modelAndView = new ModelAndView("info");
        int shopID = Integer.parseInt(session.getAttribute("shopID").toString());
        goods.setShopid(shopID);
        if (goodsService.save(goods)) {
            modelAndView.addObject("message", "操作成功");
        } else {
            modelAndView.addObject("message", "操作失败");
        }
        return modelAndView;
    }
    @RequestMapping("/updategoods")
    public ModelAndView UpdateGoods(Goods goods){
        // goodsid name price
        ModelAndView modelAndView = new ModelAndView("info");
        int shopID = Integer.parseInt(session.getAttribute("shopID").toString());
        goods.setShopid(shopID);
        if (goodsService.update(goods)) {
            modelAndView.addObject("message", "操作成功");
        } else {
            modelAndView.addObject("message", "操作失败");
        }
        return modelAndView;
    }
    @RequestMapping("/removeGoods")
    public ModelAndView RemoveGoods(Goods goods){
        ModelAndView modelAndView = new ModelAndView("info");
        goods= (Goods) goodsService.findByGoodsID(goods.getGoodsid());
        goods.setState(1);
        if (goodsService.update(goods)) {
            modelAndView.addObject("message", "操作成功");
        } else {
            modelAndView.addObject("message", "操作失败");
        }
        return modelAndView;
    }


}
