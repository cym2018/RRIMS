package xyz.cym2018.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cym2018.dao.*;
import xyz.cym2018.tools.CookieOperate;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class Customer {
    final TableRepository tableRepository;
    final ObjectMapper mapper;
    final CookieOperate cookieOperate;
    final OrderRepository orderRepository;
    final FoodRepository foodRepository;

    public Customer(TableRepository tableRepository, ObjectMapper mapper, CookieOperate cookieOperate, OrderRepository orderRepository, FoodRepository foodRepository) {
        this.tableRepository = tableRepository;
        this.mapper = mapper;
        this.cookieOperate = cookieOperate;
        this.orderRepository = orderRepository;
        this.foodRepository = foodRepository;
    }

    // 创建/选择table
    @RequestMapping("/{tables}")
    public String selectTable(@PathVariable("tables") Tables tables, @PathVariable("tables") Integer id) throws JsonProcessingException {
        // 如果没有该座位的记录,创建一个记录
        if (tables == null)
            tables = tableRepository.save(new Tables(id));

        tables.setState(tables.getOrders().tablesState());

        // 如果订单无效,创建新订单
        if (tables.getState() == 0)
            tables = tableRepository.save(tables.CreateOrders());

        return mapper.writeValueAsString(tables);
    }

    @RequestMapping("/{tables}/{foods}")
    public String selectFood(@PathVariable("tables") Tables tables, @PathVariable("foods") Foods foods, Integer number) throws JsonProcessingException {
        Orders orders;
        List<Items> itemsList;
        // 验证空值
        if (tables == null || foods == null) return "request error";
        orders = tables.getOrders();
        itemsList = orders.getItems();
        // 验证状态可修改
        if (orders.getState() > 1) return "state error";
        orders.setState(1);
        Integer index = findFoods(tables.getOrders().getItems(), foods);
        if (index != null)
            itemsList.get(index).add(number);
        else
            itemsList.add(new Items(foods, number));
        tables = tableRepository.save(tables);
        return mapper.writeValueAsString(tables);
    }

    @RequestMapping("/{tables}/submit")
    public String submitOrders(@PathVariable("tables") Tables tables) throws JsonProcessingException {
        if (tables.getOrders().getState() == 1) {
            tables.getOrders().setState(2);
            tables = tableRepository.save(tables);
        }
        return mapper.writeValueAsString(tables);
    }

    @RequestMapping("/{tables}/pay")
    public String payOrders(@PathVariable("tables") Tables tables) throws JsonProcessingException {
        if (tables.getOrders().getState() == 3) {
            tables.getOrders().setState(4);
            tables = tableRepository.save(tables);
        }
        return mapper.writeValueAsString(tables);
    }

    public Integer findFoods(List<Items> itemsList, Foods foods) {
        for (int i = 0; i < itemsList.size(); i++)
            if (itemsList.get(i).getFoods() == foods)
                return i;
        return null;
    }
}
