package com.service.point.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity
@Table
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
    private Order order;
}
