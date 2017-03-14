package com.seleznov.liquibase.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Illia Seleznov
 */
@Entity(name = "customer")
@Getter
@Setter
public class CustomerEntity {

    public static final String ID = "id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version = 0l;

    @NotBlank
    @Column(length = 50)
    private String name;

    @NotBlank
    @Email
    @Column
    private String email;

    @NotNull
    @Min(value = 0)
    @Column
    private Integer balance;


}
