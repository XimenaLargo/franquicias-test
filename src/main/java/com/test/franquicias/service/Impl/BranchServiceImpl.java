package com.test.franquicias.service.Impl;

import com.test.franquicias.model.Branch;
import com.test.franquicias.model.Product;
import com.test.franquicias.repository.BranchRepository;
import com.test.franquicias.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public void createBranch(Branch branch) {
        branchRepository.save(branch);
    }

    @Override
    public ResponseEntity<String> addNewProduct(Product product) {
        String message = " ";
        if (product != null) {
            productService.createProduct(product);
            message = "Se ha agregado un nuevo producto";
        } else {
            message = "No se ha podido agregar el producto.";
        }
        return ResponseEntity.ok().body(message);
    }

    @Override
    public ResponseEntity<String> deleteProduct (Long id){
        String message= " ";
        if (productService.searchProduct(id).isPresent()){
            productService.deleteProduct(id);
            message = "El producto con id "+  id +" ha sido eliminado. ";
        }
        else {
            message = "No se ha podido eliminar el producto.";
        }
        return  ResponseEntity.ok().body(message);
    }
}
