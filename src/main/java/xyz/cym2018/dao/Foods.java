package xyz.cym2018.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
table
    order   一对一
order
    table   多对一
    item    一对多
item
    food    一对一
 */
@Entity
public class Foods {
    @Id
    @GeneratedValue(generator = "increment")
    private Integer id;
    @Column
    private String name;
    @Column
    private Float price;
    @Column
    private Integer state=0;
    @Column
    private String picture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
