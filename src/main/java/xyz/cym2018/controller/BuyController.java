package xyz.cym2018.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.cym2018.DAO.User;
import xyz.cym2018.service.GoodsService;
import xyz.cym2018.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/Buy")
@Controller
public class BuyController {
    @Autowired
    UserService userService;
    @Autowired
    HttpSession session;
    @Autowired
    HttpServletRequest request;
    @Autowired
    GoodsService goodsService;


    @RequestMapping("/shoplist")
    public ModelAndView ShopList() {
        ModelAndView modelAndView=new ModelAndView("buy/shoplist");
        List shop=userService.SelectAllShop();
        modelAndView.addObject("shoplist",shop);
        return modelAndView;
    }
    @RequestMapping("/selectshop")
    public ModelAndView SelectShop(User user){
        ModelAndView modelAndView=new ModelAndView("buy/shop");
        List menu=goodsService.findByShopID(user.getUserid());
        modelAndView.addObject("menu",menu);
        return modelAndView;
    }

    // 购物车
//    @RequestMapping("/addintocart")
//    public ModelAndView AddIntoCart(){
//
//    }
}
