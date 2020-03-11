package xyz.cym2018.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

// 座位状态 0:空闲 1:预定 2:占用---------------
// 订单状态        0:空白 1:有效 2:已提交 3:已确认 4:已支付
//                 |可修改--------|
@Entity
public class Orders {
    @Id
    @GeneratedValue(generator = "increment")
    private Integer id;

    @JsonIgnoreProperties("orders")
    @ManyToOne
    @JoinColumn(name = "tables_id")
    private Tables tables;

    @JsonIgnoreProperties("orders")
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "orders_id")
    private List<Items> items = new ArrayList<>();

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime = Calendar.getInstance().getTime();

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date payTime;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Column
    private Integer state = 0;

    public Orders() {
    }

    public Orders(Tables tables) {
        setTables(tables);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tables getTables() {
        return tables;
    }

    public void setTables(Tables tables) {
        this.tables = tables;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @JsonIgnore
    public Integer tablesState() {
        switch (state) {
            case 0:
                if (System.currentTimeMillis() - startTime.getTime() < 300000L)
                    return 1;
                return 0;
            case 1:
            case 2:
            case 3:
                return 2;
            case 4:
        }
        return 0;
    }

}

