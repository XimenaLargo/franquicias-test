package com.test.franquicias.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "branches")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBranch;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "branch")
    @JsonIgnore
    private List<Product> productList;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "franchises_idfranchises" , nullable = false)
    private Franchise franchise;
}
