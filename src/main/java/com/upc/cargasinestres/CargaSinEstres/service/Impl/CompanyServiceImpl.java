package com.upc.cargasinestres.CargaSinEstres.service.Impl;

import com.upc.cargasinestres.CargaSinEstres.exception.ResourceNotFoundException;
import com.upc.cargasinestres.CargaSinEstres.model.Company;
import com.upc.cargasinestres.CargaSinEstres.service.ICompanyService;
import com.upc.cargasinestres.CargaSinEstres.repository.ICompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements ICompanyService{

    private final ICompanyRepository companyRepository;

    //inyeccion de dependencias
    public CompanyServiceImpl(ICompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No se encontro la empresa con id: "+id));
    }

    @Override
    public Company createCompany(Company company) {

        if (companyRepository.findByNameAndNumeroContacto(company.getName(), company.getNumeroContacto()).isPresent())
            throw new RuntimeException("Ya existe una empresa con ese nombre y numero de contacto");

        return companyRepository.save(company);
    }

}
