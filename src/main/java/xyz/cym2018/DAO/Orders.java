package xyz.cym2018.DAO;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Entity
@Table(name = "orders")
@SuppressWarnings({"SpellCheckingInspection", "unused", "WeakerAccess"})
public class Orders {
    // 自动生成
    @Id
    @GeneratedValue(generator = "increment")
    private Integer orderid;

    // 用户
    @Column
    private Integer userid;

    // 商品
    @Column
    private Integer goodsid;

    // 数量
    @Column
    private Integer number;

    @Column
    private Date paytime;
    @Column
    private Date finishtime;
    @Column
    private Date confirmtime;

//    @ManyToOne(targetEntity = Goods.class,cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
//    private Goods goods;


    public Orders() {
    }

    public Orders(int userid, int goodsid) {
        this.userid = userid;
        this.goodsid = goodsid;
        setNumber(1);
    }

    public Date getConfirmtime() {
        return confirmtime;
    }

    public void setConfirmtime(Date confirmtime) {
        this.confirmtime = confirmtime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }


    @Override
    public String toString() {
        return "orderid:" + orderid + " userid:" + userid + " goodsid:" + goodsid + " paytime:" + getPaytime() + " finishtime:" + getFinishtime();
    }

    public void Clean() {
        orderid = null;
        userid = null;
        number = null;
        goodsid = null;
        paytime = null;
        finishtime = null;
    }
}

