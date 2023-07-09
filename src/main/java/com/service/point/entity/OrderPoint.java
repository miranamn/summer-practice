package com.service.point.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity
@Table(name = "order_points")
public class OrderPoint {
    @Id
    @SequenceGenerator(
            name = "order_point_sequence",
            sequenceName = "order_point_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "order_point_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;
    @OneToMany
    private List<Order> orders;
}
