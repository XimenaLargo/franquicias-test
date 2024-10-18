package com.test.franquicias.service.Impl;

import com.test.franquicias.model.Branch;
import com.test.franquicias.model.Franchise;
import com.test.franquicias.model.Product;
import com.test.franquicias.repository.FranchiseRepository;
import com.test.franquicias.service.BranchService;
import com.test.franquicias.service.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FranchiseServiceImpl implements FranchiseService {

    @Autowired
    private FranchiseRepository franchiseRepository;

    @Autowired
    private BranchService branchService;

    @Override
    public ResponseEntity<String> createFranchise(Franchise franchise) {
        String message = " ";
        if (franchise != null){
            franchiseRepository.save(franchise);
            message = "Se ha creado exitosamente la franquicia";
        }
        else {
            message = "No se pudo crear la franquicia.";
        }
        return ResponseEntity.ok().body(message);
    }

    @Override
    public ResponseEntity<String> createBranch(Branch branch) {
        String message = " ";
        if (branch != null){
            branchService.createBranch(branch);
            message = "Se ha creado exitosamente la sucursal.";
        }
        else {
            message = "No se ha podido crear la sucursal.";
        }
        return ResponseEntity.ok().body(message);
    }

}
