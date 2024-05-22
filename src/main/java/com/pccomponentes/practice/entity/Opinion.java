package com.pccomponentes.practice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "opinion")
public class Opinion {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "created_date")
    private String createdDate;

    @Column(name = "comment")
    private String comment;

    @Column(name = "score")
    private Integer score;

    @JsonManagedReference
    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "id_product")
    private Product product;

    @JsonManagedReference
    @ManyToOne(targetEntity = Client.class)
    @JoinColumn(name = "id_client")
    private Client client;

}
