package xyz.cym2018.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.cym2018.DAO.Goods;

@Controller
@RequestMapping("/buy/shop")
public class BuyShopController extends BuyController {
    @RequestMapping("/add")
    public ModelAndView Select(Goods goods) {
        // 获取用户id,将选中商品添加到购物车
        int UserID = getUserID();
        ordersService.Buy(UserID, goods.getGoodsid());
        return Shop();
    }

    @RequestMapping("/remove")
    public ModelAndView Remove(Goods goods) {
        // 获取用户id,删除选中的商品
        int UserID = getUserID();
        ordersService.Remove(UserID, goods.getGoodsid());
        return Shop();
    }

    @RequestMapping("/pay")
    public ModelAndView Pay() {
        // 获取用户id,支付用户购物车所有商品
        int UserID = getUserID();
        ordersService.Pay(UserID);
        return Shop();
    }

}
