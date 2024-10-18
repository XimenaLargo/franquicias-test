package com.test.franquicias.repository;

import com.test.franquicias.model.Branch;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch , Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Branch b SET b.name = :newName WHERE b.idBranch = :branchId")
    void updateBranchName(@Param("branchId") Long franchiseId, @Param("newName") String newName);
}
