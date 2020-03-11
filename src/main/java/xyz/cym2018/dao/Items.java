package xyz.cym2018.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Items {
    @Id
    @GeneratedValue(generator = "increment")
    private Integer id;

    @JsonIgnoreProperties("items")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "foods_id")
    private Foods foods;

    @Column
    private Integer number;

    public Items() {
    }


    public Items(Foods foods, Integer number) {
        setFoods(foods);
        setNumber(number);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Foods getFoods() {
        return foods;
    }

    public void setFoods(Foods foods) {
        this.foods = foods;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void add(Integer number) {
        this.number += (number == null ? 1 : number);
    }
}
