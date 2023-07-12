package com.service.point.controller;

import com.service.point.entity.Order;
import com.service.point.entity.OrderPoint;
import com.service.point.service.OrderPointService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/point")
public class OrderPointController {
    @Autowired
    private OrderPointService orderPointService;
    @GetMapping
    public List<OrderPoint> getAllOrderPoints(){
        return orderPointService.getAllOrderPoints();
    }
    @PostMapping
    public ResponseEntity<String> addOrderPoint(@RequestBody @Valid OrderPoint orderPoint){
        return orderPointService.addOrderPoint(orderPoint);
    }
    @GetMapping("/{id}")
    public Optional<Order> getOrders(@PathVariable UUID id){
        return orderPointService.getOrders(id);
    }
}
