package xyz.cym2018.DAO;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Table(name = "orders")
public class Order {
//    static DateFormat df = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
    @Id
    @GeneratedValue(generator = "increment")
    private Integer orderid;
    @Column
    private Integer userid;
    @Column
    private Integer shopid;
    @Column
    private Integer goodsid;
    @DateTimeFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    @Column
    private Date paytime;

    @Column
    private Date finishtime;


    Order() {
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        System.out.println("setOrderid");
        this.orderid = orderid;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public Date getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }


    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "orderid:" + orderid + " userid:" + userid + " shopid:" + shopid + " goodsid:" + goodsid + " paytime:" + getPaytime() + " finishtime:" + getFinishtime();
    }
}

