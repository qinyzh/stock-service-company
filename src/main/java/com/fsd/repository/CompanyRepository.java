package com.fsd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fsd.domain.Company;

public interface CompanyRepository extends JpaRepository<Company,Long>{

    Company findById(Integer id);

    @Query(name = "getByCompanycode", nativeQuery = true, value = "SELECT company_name from company where company_code = :companycode")
    String getByCompanycode(String companycode);


}