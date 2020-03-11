package xyz.cym2018.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cym2018.dao.*;
import xyz.cym2018.tools.CookieOperate;

import java.util.List;

@RestController
public class Everyone {
    final TableRepository tableRepository;
    final ItemRepository itemRepository;
    final OrderRepository orderRepository;
    final FoodRepository foodRepository;
    final ObjectMapper mapper;
    final CookieOperate cookieOperate;

    public Everyone(TableRepository tableRepository, ItemRepository itemRepository, OrderRepository orderRepository, FoodRepository foodRepository, ObjectMapper mapper, CookieOperate cookieOperate) {
        this.tableRepository = tableRepository;
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
        this.foodRepository = foodRepository;
        this.mapper = mapper;
        this.cookieOperate = cookieOperate;
    }

    @RequestMapping("/foods")
    public String foodsList() throws JsonProcessingException {
        return mapper.writeValueAsString(foodRepository.findAll());
    }

    @RequestMapping("/tables")
    public String tablesList() throws JsonProcessingException {
        refreshTables();
        return mapper.writeValueAsString(tableRepository.findAll());
    }

    // 刷新座位状态
    public void refreshTables() {
        List<Tables> list = tableRepository.findAll();
        for (Tables i : list)
            i.setState(i.getOrders().tablesState());
        tableRepository.saveAll(list);
    }
}
