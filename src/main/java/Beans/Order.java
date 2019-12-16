package Beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("order")
@Scope
public class Order {
    private String id;
    private Date creatTime,startTime,finishTime;
    private int state;
    private String[] list;
}
