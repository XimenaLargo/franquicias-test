package com.test.franquicias.repository;

import com.test.franquicias.model.Franchise;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise , Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Franchise f SET f.name = :newName WHERE f.idFranchise = :franchiseId")
    void updateFranchiseName(@Param("franchiseId") Long franchiseId, @Param("newName") String newName);

}
