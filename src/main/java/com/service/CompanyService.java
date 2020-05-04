package com.service;

import com.domain.Company;
import com.util.ResponseResult;

public interface CompanyService {
    ResponseResult findAll();
    ResponseResult findById(Integer id);
    String getByCompanycode(String companycode);
    ResponseResult save(Company company);

}