package com.service.point.repository;

import com.service.point.entity.Order;
import com.service.point.entity.OrderPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderPointRepository extends JpaRepository<OrderPoint, UUID> {
    @Query(value = "", nativeQuery = true)
    Optional<Order> findOrderById(UUID id);
}
