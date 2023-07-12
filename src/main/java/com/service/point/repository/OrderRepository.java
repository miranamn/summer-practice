package com.service.point.repository;

import com.service.point.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    @Query(value = "SELECT * FROM orders o WHERE o.user_id=?1", nativeQuery = true)
    Optional<Order> findOrderByUserId(UUID id);
    Order findOrderById(UUID id);
}
