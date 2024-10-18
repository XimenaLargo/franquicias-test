package com.test.franquicias.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    @Column
    private String name;

    @Column
    private int stock;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "branches_idbranches" , nullable = false)
    private Branch branch;
}
