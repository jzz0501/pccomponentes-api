package com.pccomponentes.practice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido_detail")
public class PedidoDetail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "unit_price", precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "quantity")
    private Integer quantity;

    @JsonManagedReference
    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "id_product")
    private Product product;

    @JsonManagedReference
    @ManyToOne(targetEntity = Pedido.class)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

}
