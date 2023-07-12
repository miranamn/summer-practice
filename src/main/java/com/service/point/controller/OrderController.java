package com.service.point.controller;

import com.service.point.controller.request.SetHistoryRequest;
import com.service.point.entity.Order;
import com.service.point.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
    @GetMapping("/{id}")
    public Optional<Order> getUserOrders(@PathVariable UUID id){
        return orderService.getUserOrders(id);
    }
    @PostMapping
    public ResponseEntity<String> addOrder(@RequestBody @Valid Order order){
        return orderService.addOrder(order);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> putOrder(@PathVariable UUID id, @RequestBody @Valid SetHistoryRequest request){
        return orderService.putOrder(request, id);
    }

}
