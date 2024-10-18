package com.test.franquicias.controller;

import com.test.franquicias.model.Product;
import com.test.franquicias.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PutMapping("/changeStock/{id}")
    public ResponseEntity<String> updateStock(@PathVariable Long id, @RequestParam Integer stock) {
        return productService.updateStockProduct(id, stock);
    }

    @GetMapping("/top-stock/{franchiseId}")
    public ResponseEntity<List<Product>> getTopStockProducts(@PathVariable Long franchiseId) {
        List<Product> products = productService.getTopStockProductsByFranchise(franchiseId);
        return ResponseEntity.ok(products);
    }
}
