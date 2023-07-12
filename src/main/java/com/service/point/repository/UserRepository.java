package com.service.point.repository;

import com.service.point.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    @Query(value = "SELECT * FROM users WHERE users.phone=?1", nativeQuery = true)
    Optional<User> findByPhone(String phone);

    Optional<User> findById(UUID id);
}
