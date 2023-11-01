package com.upc.cargasinestres.CargaSinEstres.service;

import com.upc.cargasinestres.CargaSinEstres.model.Company;

import java.util.List;

public interface ICompanyService {

    //get all companies
    public abstract List<Company> getAllCompanies();

    //get company by id
    public abstract Company getCompanyById(Long id);

    //create company
    public abstract Company createCompany(Company company);

    //update company (por ver aun)
    //public abstract Company updateCompany(Long id, Company company);

}
