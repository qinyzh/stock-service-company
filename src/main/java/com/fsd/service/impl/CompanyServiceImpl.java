package com.fsd.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.domain.Company;
import com.fsd.repository.CompanyRepository;
import com.fsd.service.CompanyService;
import com.fsd.util.DateUtil;
import com.fsd.util.ResponseCode;
import com.fsd.util.ResponseResult;
import com.fsd.vo.CompanyCompareVo;

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

	@Override
	public ResponseResult updateCompanyById(Company company) {
		try {
			
            Company oldCompany = this.companyRepository.findById(company.getId());
            oldCompany.setCompanyname(company.getCompanyname());
            oldCompany.setCompanycode(company.getCompanycode());
            oldCompany.setTurnover(company.getTurnover());
            oldCompany.setCeo(company.getCeo()); 
            oldCompany.setBoardofdirector(company.getBoardofdirector());
            oldCompany.setListedinse(company.getListedinse());
            oldCompany.setSectorname(company.getSectorname());
            oldCompany.setWriteup(company.getWriteup());
            oldCompany.setStockcode(company.getStockcode());   
            oldCompany.setCompanystatus(company.getCompanystatus());
            this.companyRepository.save(oldCompany);
            return ResponseResult.build(ResponseCode.SUCCESS, "SUCCESS!");
        } catch (Exception e) {
        	return ResponseResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        }
	}

	@Override
	public ResponseResult compareCompany(CompanyCompareVo condition) {
		List chartData = new ArrayList();
		try {
			String fromdate = condition.getFromdate();
			String todate = condition.getTodate();
			String periodicity = condition.getPeriodicity();
			List companys = condition.getCompanys();
			
			//List<String> dateList = DateUtil.cutDate(periodicity, fromdate, todate);
			List dataList = new ArrayList();
			for(int i = 0; i<companys.size(); i++) {
				Map company =  (HashMap)companys.get(i);
				String type = (String)company.get("type");
				String stockexchange = (String)company.get("stockexchange");
				String companyname = (String)company.get("companyname");
				if(type.equals("0")) {
					//company
					chartData = companyRepository.getChartByMonth(companyname,stockexchange,fromdate,todate);
					for(int j=0;j<chartData.size();j++) {
						
					}
				}
				
				
			}
			
			return ResponseResult.build(ResponseCode.SUCCESS, "SUCCESS!",chartData);
		} catch (Exception e) {
        	return ResponseResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        }
		
	}
	
	 

}