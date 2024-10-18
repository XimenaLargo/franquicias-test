package com.test.franquicias.service;

import com.test.franquicias.model.Branch;
import com.test.franquicias.model.Franchise;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FranchiseService {

    ResponseEntity<String> createFranchise (Franchise franchise);

    ResponseEntity<String> createBranch (Branch branch);

    ResponseEntity<String> updateNameFranchise (Long id , String name);
}
