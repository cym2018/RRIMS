package xyz.cym2018.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.cym2018.DAO.Goods;
import xyz.cym2018.service.GoodsService;

@SuppressWarnings({"SpringJavaAutowiredFieldsWarningInspection", "unused"})
@Controller
@RequestMapping("/sell/menu")
public class SellMenuController extends SessionOperate {
    Logger logger = LogManager.getLogger(SellMenuController.class);
    @Autowired
    GoodsService goodsService;

    @RequestMapping("/creat")
    public ModelAndView Add(Goods goods) {
        ModelAndView modelAndView = new ModelAndView("message");
        goods.setShopid(getShopId());
        modelAndView.addObject("message", goodsService.Creat(goods) ? "操作成功" : "操作失败");
        return modelAndView;
    }

    @RequestMapping("/select")
    public ModelAndView Select(Goods goods) {
        ModelAndView modelAndView = new ModelAndView("sell/menu/update");
        goods = goodsService.goodsidQuery(goods.getGoodsid());
        modelAndView.addObject("goods", goods);
        return modelAndView;
    }

    @RequestMapping("/update")
    public ModelAndView Update(Goods goods) {
        ModelAndView modelAndView = new ModelAndView("message");
        goods.setShopid(getShopId());
        modelAndView.addObject("message", goodsService.Update(goods) ? "操作成功" : "操作失败");
        return modelAndView;
    }

    @RequestMapping("/delete")
    public ModelAndView Remove(Goods goods) {
        ModelAndView modelAndView = new ModelAndView("message");
        modelAndView.addObject("message", goodsService.Delete(goods) ? "操作成功" : "操作失败");
        return modelAndView;
    }


}
