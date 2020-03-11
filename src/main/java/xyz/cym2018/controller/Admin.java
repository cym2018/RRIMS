package xyz.cym2018.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cym2018.dao.*;
import xyz.cym2018.tools.CookieOperate;

@RestController
@RequestMapping("/admin")
public class Admin {
    final TableRepository tableRepository;
    final ItemRepository itemRepository;
    final OrderRepository orderRepository;
    final FoodRepository foodRepository;
    final ObjectMapper mapper;
    final CookieOperate cookieOperate;

    public Admin(TableRepository tableRepository, ItemRepository itemRepository, OrderRepository orderRepository, FoodRepository foodRepository, ObjectMapper mapper, CookieOperate cookieOperate) {
        this.tableRepository = tableRepository;
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
        this.foodRepository = foodRepository;
        this.mapper = mapper;
        this.cookieOperate = cookieOperate;
    }

    @RequestMapping("/foods/add")
    public String addFoods(Foods foods) throws JsonProcessingException {
        foods = foodRepository.save(foods);
        return mapper.writeValueAsString(foods);
    }

    @RequestMapping("/confirm/{tables}")
    public String confirmOrders(@PathVariable("tables") Tables tables) throws JsonProcessingException {
        if (tables.getOrders().getState() == 2) {
            tables.getOrders().setState(3);
            tables = tableRepository.save(tables);
        }
        return mapper.writeValueAsString(tables);
    }

}
