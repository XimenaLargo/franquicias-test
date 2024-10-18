package com.test.franquicias.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "franchises")
public class Franchise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFranchise;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "franchise")
    private List<Branch> branchList;
}
