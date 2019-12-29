package xyz.cym2018.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import xyz.cym2018.DAO.Orders;

import java.util.Date;
import java.util.List;


@SuppressWarnings({"WeakerAccess", "UnusedReturnValue", "unused"})
@Service
public class OrdersService extends TService<Orders> {

    private static Logger logger = LogManager.getLogger(OrdersService.class);

    // 购买,传入 userId goodsId
    public boolean Buy(int userId, int goodsId) {
        Orders orders = aQuery(userId, goodsId);
        // 检测购物车中是否存在
        if (orders == null) {
            // 不存在,建立新记录
            orders = new Orders(userId, goodsId);
            return Creat(orders);
        } else {
            // 存在,数量+1,更新
            orders.setNumber(orders.getNumber() + 1);
            return Update(orders);
        }
    }

    // 移除购物车中的内容
    public boolean Remove(int userId, int goodsId) {
        Orders orders = aQuery(userId, goodsId);
        // 检测购物车中是否存在
        if (orders == null) {
            // 不存在,输出日志信息
            logger.warn("Remove():删除不存在的内容");
            return true;
        } else {
            // 存在,删除记录
            return Delete(orders);
        }
    }

    // 付款
    public void Pay(int userId) {
        // 查询购物车中的内容
        List list = aQuery(userId);
        // 逐个更新
        for (Object orders : list) {
            ((Orders) orders).setPaytime(new Date(System.currentTimeMillis()));
            Update((Orders) orders);
        }
    }


    // 订单状态A:未支付,未确认,未收货
    public List aQuery(int userId) {
        HQL = "from xyz.cym2018.DAO.Orders where userId=?1 and paytime is null";
        values = new Object[]{userId};
        return QueryList();
    }

    public Orders aQuery(int userId, int goodsId) {
        HQL = "from xyz.cym2018.DAO.Orders where userId=?1 and goodsId=?2 and paytime is null";
        values = new Object[]{userId, goodsId};
        return QueryObject();
    }

    // 订单状态B:已支付,未确认,未收货
    public List bQuery(int userId) {
        HQL = "from xyz.cym2018.DAO.Orders where userId=?1 and paytime != null and confirmtime is null";
        values = new Object[]{userId};
        return QueryList();
    }

    // 订单状态C:已支付,已确认,未收货
    public List cQuery(int userId) {
        HQL = "from xyz.cym2018.DAO.Orders where userId=?1 and confirmtime != null and finishtime is null";
        values = new Object[]{"" + userId};
        return QueryList();
    }

    // 订单状态D 已支付,已确认,已收货
    public List dQuery(int userId) {
        HQL = "from xyz.cym2018.DAO.Orders where userId=?1 and finishtime != null";
        values = new Object[]{userId};
        return QueryList();
    }

}