package com.pccomponentes.practice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "slug")
    private String slug;

    @Column(name = "name")
    private String name;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "lowest_price", precision = 10, scale = 2)
    private BigDecimal lowestPrice;

    @Column(name = "webURL")
    private String webURL;

    @Column(name = "imageURL")
    private String imageURL;

    @Column(name = "discount", precision = 4, scale = 2)
    private BigDecimal discount;

    @JsonManagedReference
    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "id_category")
    private Category category;

    @JsonBackReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<BasketProduct> basketProducts;

    @JsonBackReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Opinion> opinions;

    @JsonBackReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<PedidoDetail> pedidoDetails;

}
