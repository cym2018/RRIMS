package xyz.cym2018.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
// 状态0:空闲 状态1:预定 状态2:占用
/*
table
    order 一对一
order
    table 多对一
    item 一对多
item
    food 一对一
 */
@Entity
public class Tables {
    @Id
    private Integer id;
    @Column
    private Integer state = 0;

    @JsonIgnoreProperties("tables")
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "orders_id")
    private Orders orders;

    public Tables() {
    }

    public Tables(Integer id) {
        setId(id);
        setOrders(new Orders(this));
        setState(1);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Tables CreateOrders() {
        setOrders(new Orders(this));
        setState(1);
        return this;
    }
}
