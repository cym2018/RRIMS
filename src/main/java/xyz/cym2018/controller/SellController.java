package xyz.cym2018.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.cym2018.DAO.User;
import xyz.cym2018.service.GoodsService;
import xyz.cym2018.service.UserService;

import java.util.List;

@SuppressWarnings({"SpringJavaAutowiredFieldsWarningInspection", "unused"})
@RequestMapping("/sell")
@Controller
public class SellController extends SessionOperate {
    Logger logger = LogManager.getLogger(SellController.class);
    @Autowired
    GoodsService goodsService;
    @Autowired
    UserService userService;


    @RequestMapping("/creat")
    public ModelAndView Creat(User userInfo) {
        ModelAndView modelAndView = new ModelAndView("message");
        // 设置店铺信息
        userInfo.setBelong(getUserID());
        userInfo.setType(2);
        // 注册
        modelAndView.addObject("message", userService.Register(userInfo) ? "创建成功" : "创建失败");
        return modelAndView;
    }

    @RequestMapping("/info")
    public ModelAndView Info(int shopId) {
        ModelAndView modelAndView = new ModelAndView("sell/info");
        // 保存店铺信息
        setShopId(shopId);
        // 查询店铺,店主信息
        User shopInfo = userService.QueryByUserID(shopId);
        User ownerInfo = userService.QueryByUserID(getUserID());

        modelAndView.addObject("shopInfo", shopInfo);
        modelAndView.addObject("ownerInfo", ownerInfo);
        return modelAndView;
    }

    @RequestMapping("/menu")
    public ModelAndView Menu() {
        ModelAndView modelAndView = new ModelAndView("message");
        // 获取用户id和店铺id
        int shopID = getShopId();
        int userId = getUserID();
        // 验证权限
        User shop = userService.QueryByUserID(shopID);
        if (shop.getBelong() != userId) {
            // 无权限
            modelAndView.addObject("message", "操作失败,无权访问");
        } else {
            // 获取菜单
            List menuList = goodsService.ShopMenu(shopID);
            modelAndView.addObject("menu", menuList);
            modelAndView.setViewName("sell/menu");
        }
        return modelAndView;
    }


}
