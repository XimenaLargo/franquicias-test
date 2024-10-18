package com.test.franquicias.service.Impl;

import com.test.franquicias.model.Franchise;
import com.test.franquicias.model.Product;
import com.test.franquicias.repository.ProductRepository;
import com.test.franquicias.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void createProduct (Product product){
        productRepository.save(product);
    }

    @Override
    public Optional<Product> searchProduct (Long id){
        return productRepository.findById(id);
    }

    @Override
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<String> updateStockProduct(Long id, Integer newStock) {
        Optional<Product> productSearched = productRepository.findById(id);
        String message = " ";

        if (productSearched.isPresent()){
            productSearched.get().setStock(newStock);
            message = "Se ha actualizado el stock del producto: " + productSearched.get().getName();
        }
        else {
            message = "No se ha podido actualizar el stock.";
        }
        return ResponseEntity.ok().body(message);
    }

    @Override
    public List<Product> getTopStockProductsByFranchise(Long franchiseId) {
        return productRepository.findTopStockProductsByFranchise(franchiseId);
    }

    @Override
    public ResponseEntity<String> updateNameProduct (Long id , String name) {
        Optional<Product> searchedProduct = productRepository.findById(id);
        String message = " ";

        if (searchedProduct.isPresent()){
            productRepository.updateProductName(id,name);
            message = "Se ha actualzado el nombre del producto";
        }
        else {
            message = "No se pudo realizar el cambio";
        }
        return ResponseEntity.ok().body(message);
    }
}
