package com.test.franquicias.controller;

import com.test.franquicias.model.Product;
import com.test.franquicias.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping("/newProduct")
    public ResponseEntity<String> newProduct (@RequestBody Product product){
        return branchService.addNewProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct (@PathVariable Long id){
        return branchService.deleteProduct(id);
    }

    @PutMapping("/changeName/{id}")
    public ResponseEntity<String> updateBranchName(@PathVariable Long id, @RequestParam String name) {
        return  branchService.updateNameBranch(id , name);
    }
}
