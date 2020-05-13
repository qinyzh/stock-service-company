package com.fsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.domain.Company;
import com.fsd.service.CompanyService;
import com.fsd.util.ResponseResult;
import com.fsd.vo.CompanyCompareVo;

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

    @PostMapping
    public ResponseResult addCompany(@RequestBody Company company){
        return companyService.save(company);
    }
    
    @PutMapping
    public ResponseResult editCompany(@RequestBody Company company) {
    	return companyService.updateCompanyById(company);
    }
    
    @PostMapping("/chart")
    public ResponseResult generateChart(@RequestBody CompanyCompareVo condition){
        return companyService.compareCompany(condition);
    }

}