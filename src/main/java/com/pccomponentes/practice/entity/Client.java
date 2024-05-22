package com.pccomponentes.practice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "birthday")
    private String birthday;

    @OneToOne
    @JoinColumn(name = "id_basket")
    private Basket basket;

    @JsonBackReference
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Opinion> opinions;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_client")
    private List<Pedido> pedidos;

}
