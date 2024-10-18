package com.test.franquicias.repository;

import com.test.franquicias.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product , Long> {

    @Query("SELECT p FROM Product p " +
            "JOIN p.branch b " +
            "JOIN b.franchise f " +
            "WHERE f.id = :franchiseId " +
            "AND p.stock = (" +
            "  SELECT MAX(p2.stock) " +
            "  FROM Product p2 " +
            "  WHERE p2.branch.id = b.id" +
            ")")
    List<Product> findTopStockProductsByFranchise(@Param("franchiseId") Long franchiseId);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.name = :newName WHERE p.idProduct = :productId")
    void updateProductName(@Param("productId") Long franchiseId, @Param("newName") String newName);
}
