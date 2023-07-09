package com.service.point.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import static jakarta.persistence.GenerationType.SEQUENCE;


@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;
    @NotBlank(message="{name is invalid}")
    @Size(min = 4, max = 30, message="{size is invalid}" )
    private String name;
    @NotBlank(message="{phone is invalid}")
    @Column(length = 11)
    private String phone;
    @NotBlank(message="{password is invalid}")
    @Size(min = 4, max = 15, message="{size is invalid}")
    private String password;
}
