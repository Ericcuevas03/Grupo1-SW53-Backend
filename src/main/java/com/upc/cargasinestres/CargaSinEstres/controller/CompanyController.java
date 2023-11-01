package com.upc.cargasinestres.CargaSinEstres.controller;

import com.upc.cargasinestres.CargaSinEstres.model.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.upc.cargasinestres.CargaSinEstres.service.ICompanyService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CompanyController {

    private final ICompanyService companyService;

    public CompanyController(ICompanyService companyService) {
        this.companyService = companyService;
    }

    //Retorna todos los companies
    @GetMapping("/companies")
    public ResponseEntity<List<Company>> getAllCompanies() {
        var res = companyService.getAllCompanies();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/companies")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        var res = companyService.createCompany(company);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


}
