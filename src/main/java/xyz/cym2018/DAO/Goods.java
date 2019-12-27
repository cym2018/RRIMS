package xyz.cym2018.DAO;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;

@Component
@Entity
@Table(name = "goods")
public class Goods {
    @Id
    @GeneratedValue(generator = "increment")
    private int goodsid;

    @Column
    private String name;
    @Column
    private BigDecimal price;
    @Column
    private int state;

    Goods() {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
