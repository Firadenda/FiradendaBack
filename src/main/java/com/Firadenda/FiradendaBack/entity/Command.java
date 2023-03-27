package com.Firadenda.FiradendaBack.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Item> items;

    private double total;

    @OneToOne
    private CreditCard creditCard;

    private String firstName;

    private String lastName ;

    private String address ;

}
