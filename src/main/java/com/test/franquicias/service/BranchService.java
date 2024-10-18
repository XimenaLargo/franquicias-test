package com.test.franquicias.service;

import com.test.franquicias.model.Branch;
import com.test.franquicias.model.Product;
import org.springframework.http.ResponseEntity;

public interface BranchService {

    public void createBranch (Branch branch);

    ResponseEntity<String> addNewProduct(Product product);

    ResponseEntity<String> deleteProduct(Long id);
}
