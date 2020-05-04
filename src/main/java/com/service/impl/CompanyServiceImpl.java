package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.Company;
import com.repository.CompanyRepository;
import com.service.CompanyService;
import com.util.ResponseCode;
import com.util.ResponseResult;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public ResponseResult findAll() {
        try {
            List<Company> list = this.companyRepository.findAll();
            return ResponseResult.build(ResponseCode.SUCCESS, "SUCCESS!", list);
        } catch (Exception e) {
            return ResponseResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        }  
    }

    @Override
    public ResponseResult findById(Integer id) {
        try {
            Company company = this.companyRepository.findById(id);
            return ResponseResult.build(ResponseCode.SUCCESS, "SUCCESS!", company);
        } catch (Exception e) {
            return ResponseResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        }  
    }

    @Override
    public String getByCompanycode(String companycode) {
        return this.companyRepository.getByCompanycode(companycode);
    }

    @Override
    public ResponseResult save(Company company) {
        try {
            Company _company = this.companyRepository.save(company);
            return ResponseResult.build(ResponseCode.SUCCESS, "SUCCESS!", _company);
        } catch (Exception e) {
            return ResponseResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        }
        
    }

}