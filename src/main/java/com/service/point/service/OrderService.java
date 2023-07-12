package com.service.point.service;

import com.service.point.controller.request.SetHistoryRequest;
import com.service.point.entity.Order;
import com.service.point.entity.Status;
import com.service.point.entity.User;
import com.service.point.exception.ValidPostException;
import com.service.point.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    public Optional<Order> getUserOrders(UUID id){
        return orderRepository.findOrderByUserId(id);
    }
    public ResponseEntity<String> addOrder(Order order){
        orderRepository.save(order);
        return ResponseEntity.ok("adding was success");
    }
    @Transactional
    public ResponseEntity<String> putOrder(SetHistoryRequest request, UUID id){
        Order order = this.orderRepository.findById(id).orElseThrow(() -> new ValidPostException(
                "order with id " + id + " does not exists"));
        Map<String, Status> history = order.getHistory();
        history.put(request.getPlace(), request.getStatus());
        order.setHistory(history);
        return ResponseEntity.ok("updating was success");
    }
}
