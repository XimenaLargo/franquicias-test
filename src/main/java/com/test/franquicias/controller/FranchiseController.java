package com.test.franquicias.controller;

import com.test.franquicias.model.Branch;
import com.test.franquicias.model.Franchise;
import com.test.franquicias.service.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/franchises")
public class FranchiseController {

    @Autowired
    private FranchiseService franchiseService;

    @PostMapping("/newFranchise")
    public ResponseEntity<String> createFranchise (@RequestBody Franchise franchise){
        return franchiseService.createFranchise(franchise);
    }

    @PostMapping("/branches/newBranch")
    public ResponseEntity<String> createBranch (@RequestBody Branch branch){
        return franchiseService.createBranch(branch);
    }
}
