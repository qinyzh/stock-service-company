package com.fsd.service;

import com.fsd.domain.Company;
import com.fsd.util.ResponseResult;
import com.fsd.vo.CompanyCompareVo;

public interface CompanyService {
    ResponseResult findAll();
    ResponseResult findById(Integer id);
    String getByCompanycode(String companycode);
    ResponseResult save(Company company);
    ResponseResult updateCompanyById(Company company);
    ResponseResult compareCompany(CompanyCompareVo condition);

}