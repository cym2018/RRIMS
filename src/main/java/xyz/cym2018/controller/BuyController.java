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

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"SpringJavaAutowiredFieldsWarningInspection", "unused"})
@RequestMapping("/buy")
@Controller
public class BuyController extends SessionOperate {
    Logger logger = LogManager.getLogger(BuyController.class);
    @Autowired
    UserService userService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    OrdersService ordersService;

    @RequestMapping("/list")
    public ModelAndView ShopList() {
        ModelAndView modelAndView = new ModelAndView("buy/list");
        List shop = userService.QueryShopList();
        modelAndView.addObject("shopList", shop);
        return modelAndView;
    }


    @RequestMapping("/shop")
    public ModelAndView SetShop(User shopInfo) {
        session.setAttribute("shopId", shopInfo.getUserid());
        return Shop();
    }


    // 查询订单,获取订单对应的商品信息 todo:用jpa一对多简化
    private List<Cart> getCartList(List<Orders> ordersList) {
        ArrayList<Cart> cartList = new ArrayList<>();
        for (Orders orders : ordersList) {
            Goods goods = goodsService.goodsidQuery(orders.getGoodsid());
            cartList.add(new Cart(orders, goods));
        }
        return cartList;
    }

    // 计算总价
    private float getSumPrice(List<Cart> cartList) {
        float sumPrice = 0;
        for (Cart cart : cartList) {
            sumPrice += (cart.getGoods().getPrice() * cart.getOrders().getNumber());
        }
        return sumPrice;
    }

    ModelAndView Shop() {
        ModelAndView modelAndView = new ModelAndView("buy/shop");
        // 用户id 商店id
        int UserID = getUserID(), shopId = getShopId();
        // 查询未支付订单
        @SuppressWarnings("unchecked")
        List<Orders> ordersList = ordersService.aQuery(UserID);
        // 生成购物车列表
        List<Cart> cartList = getCartList(ordersList);
        // 计算价格
        float sumPrice = getSumPrice(cartList);
        // 传值
        modelAndView.addObject("shopMenu", goodsService.ShopMenu(shopId));
        modelAndView.addObject("cartList", cartList);
        modelAndView.addObject("sumPrice", sumPrice);
        return modelAndView;
    }

}
