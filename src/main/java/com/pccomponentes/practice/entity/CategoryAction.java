package com.pccomponentes.practice.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category_action")
public class CategoryAction {

    @Id
    @Column(name = "id_category")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "imageURL")
    private String imageURL;

    @Column(name = "webURL")
    private String webURL;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    private Category category;

}
