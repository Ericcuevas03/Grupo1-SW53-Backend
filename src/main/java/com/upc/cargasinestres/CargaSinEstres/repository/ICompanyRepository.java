package com.upc.cargasinestres.CargaSinEstres.repository;

import com.upc.cargasinestres.CargaSinEstres.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByNameAndNumeroContacto(String name, String numeroContacto);

}
