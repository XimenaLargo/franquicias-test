package com.test.franquicias.repository;

import com.test.franquicias.model.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise , Long> {

}
