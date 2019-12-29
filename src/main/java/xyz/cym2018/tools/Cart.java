package xyz.cym2018.tools;

import xyz.cym2018.DAO.Goods;
import xyz.cym2018.DAO.Orders;

@SuppressWarnings({"WeakerAccess", "unused"})
public class Cart {

    private Orders orders;
    private Goods goods;

    public Cart() {
    }

    public Cart(Orders orders, Goods goods) {
        setGoods(goods);
        setOrders(orders);
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
