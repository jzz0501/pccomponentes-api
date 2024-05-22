package com.pccomponentes.practice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "basket_product")
public class BasketProduct {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonManagedReference
    @ManyToOne(targetEntity = Basket.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_basket")
    private Basket basket;

    @JsonManagedReference
    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "id_product")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

}
