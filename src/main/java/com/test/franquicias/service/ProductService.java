package com.test.franquicias.service;

import com.test.franquicias.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public void createProduct (Product product);

    Optional<Product> searchProduct (Long id);

    public void deleteProduct(Long id);

    public ResponseEntity<String> updateStockProduct (Long id , Integer newStock);

    List<Product> getTopStockProductsByFranchise(Long franchiseId);

    ResponseEntity<String> updateNameProduct (Long id , String name);
}
