package com.service.point.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(unique = true)
    private UUID id;
    @ManyToOne
    private User user;
    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    private List<String> positions;
    @NotNull
    private Long cost;
    private Date data = new Date();
    @ElementCollection
    @MapKeyColumn(name = "history")
    @Column(name = "history_value")
    @CollectionTable(name = "history_attributes", joinColumns = @JoinColumn(name = "order_id"))
    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    @JsonPropertyOrder({"place", "status"})
    private Map<String, Status> history;
}
