package xyz.cym2018.DAO;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@SuppressWarnings({"unused"})
@Component
@Entity
@Table(name = "goods")
public class Goods {
    @Id
    @GeneratedValue(generator = "increment")
    private int goodsid;
    @Column
    private int shopid;
    @Column
    private String name;
    @Column
    private float price;
    @Column
    private int state;
    public Goods() {
    }

    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    @Override
    public String toString() {
        return "goodsid:" + goodsid + " name:" + name + " price:" + price + " state:" + state;
    }
}
