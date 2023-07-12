package com.service.point.service;

import com.service.point.entity.Order;
import com.service.point.entity.OrderPoint;
import com.service.point.repository.OrderPointRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderPointService {
    @Autowired
    OrderPointRepository orderPointRepository;
    public List<OrderPoint> getAllOrderPoints(){
        return orderPointRepository.findAll();
    }
    public ResponseEntity<String> addOrderPoint(OrderPoint orderPoint){
        orderPointRepository.save(orderPoint);
        return ResponseEntity.ok("adding was success");
    }
    public Optional<Order> getOrders(UUID id){
        return orderPointRepository.findOrderById(id);
    }
}
