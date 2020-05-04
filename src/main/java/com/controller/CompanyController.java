package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.Company;
import com.service.CompanyService;
import com.util.ResponseResult;

@CrossOrigin
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/list")
    public ResponseResult queryCompanyAll() {
        return companyService.findAll();
    }

    @GetMapping("/list/{id}")
    public ResponseResult queryCompanyById(@PathVariable Integer id){
        return companyService.findById(id);
    }

    @PostMapping("/add")
    public ResponseResult addCompany(@RequestBody Company company){
        return companyService.save(company);
    }

}