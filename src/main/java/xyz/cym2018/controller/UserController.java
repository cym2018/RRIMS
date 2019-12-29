package xyz.cym2018.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.cym2018.DAO.Goods;
import xyz.cym2018.DAO.Orders;
import xyz.cym2018.DAO.User;
import xyz.cym2018.service.GoodsService;
import xyz.cym2018.service.OrdersService;
import xyz.cym2018.service.UserService;
import xyz.cym2018.tools.Cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unused", "SpringJavaAutowiredFieldsWarningInspection"})
@Controller
@RequestMapping("/user")
public class UserController extends SessionOperate {
    @Autowired
    OrdersService ordersService;
    @Autowired
    UserService userService;
    @Autowired
    HttpSession session;
    @Autowired
    GoodsService goodsService;
    @Autowired
    HttpServletRequest request;
    private Logger logger = LogManager.getLogger(UserController.class);


    @RequestMapping("/info")
    public ModelAndView Info() {
        int UserID;
        ModelAndView modelAndView = new ModelAndView("user/info");

        // 获取用户id
        UserID =getUserID();
        // 查询用户信息
        User uUser = userService.QueryByUserID(UserID);
        modelAndView.addObject("userInfo", uUser);
        // 查询店铺信息
        List Shop = userService.QueryByShopOwner(uUser.getUserid());
        modelAndView.addObject("shopInfo", Shop);

        // 查询待签收物品
        @SuppressWarnings("unchecked")
        List<Orders> ordersList = ordersService.bQuery(UserID);
        ArrayList<Cart> cart = new ArrayList<>();
        for (Orders orders : ordersList) {
            Goods goods = goodsService.goodsidQuery(orders.getGoodsid());
            cart.add(new Cart(orders, goods));
        }
        modelAndView.addObject("cart", cart);

        return modelAndView;
    }


}
