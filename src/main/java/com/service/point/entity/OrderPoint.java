package com.service.point.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name = "order_points")
public class OrderPoint {
    @Id
    @GeneratedValue
    @Column(unique = true)
    private UUID id;
    @OneToMany
    private List<Order> orders;

    private Long index;
    @NotBlank
    private String address;
}
