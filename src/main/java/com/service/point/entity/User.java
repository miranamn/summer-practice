package com.service.point.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;



@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(unique = true)
    private UUID id;
    @NotBlank(message="{name is invalid}")
    @Size(min = 4, max = 30, message="{size is invalid}" )
    private String name;
    @NotBlank(message="{phone is invalid}")
    @Column(length = 11,  unique = true)
    private String phone;
    @NotBlank(message="{password is invalid}")
    @Size(min = 4, max = 15, message="{size is invalid}")
    private String password;
}
