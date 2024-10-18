package com.test.franquicias.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "franchises")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Franchise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFranchise;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "franchise")
    @JsonIgnore
    private List<Branch> branchList;
}
