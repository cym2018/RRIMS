package xyz.cym2018.test;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component("Order")
public class Order {
    private String id;
    private Date creatTime, startTime, finishTime;
    private int state;
    private String[] list;

    public Date getCreatTime() {
        return creatTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public int getState() {
        return state;
    }

    public String getId() {
        return id;
    }

    public String[] getList() {
        return list;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setList(String[] list) {
        this.list = list;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setState(int state) {
        this.state = state;
    }
}
