package com.fsd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.domain.Ipodetail;
import com.fsd.repository.IpodetailRepository;
import com.fsd.service.IpodetailService;
import com.fsd.util.ResponseCode;
import com.fsd.util.ResponseResult;

@Service
public class IpodetailServiceImpl implements IpodetailService{

	@Autowired
	private IpodetailRepository ipodetailRepository;
	
	@Override
	public ResponseResult findAll() {
		
		try {
			List<Ipodetail> list = this.ipodetailRepository.findAll();
            return ResponseResult.build(ResponseCode.SUCCESS, "SUCCESS!", list);
        } catch (Exception e) {
            return ResponseResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        }  
	}

	@Override
	public ResponseResult updateIpodetailById(Ipodetail ipodetail) {
		
		try {
			Ipodetail oldIpodetail = this.ipodetailRepository.findById(ipodetail.getId());
			oldIpodetail.setCompanyname(ipodetail.getCompanyname());
			oldIpodetail.setStockexchange(ipodetail.getStockexchange());
			oldIpodetail.setPricepershare(ipodetail.getPricepershare());
			oldIpodetail.setTotalnum(ipodetail.getTotalnum());
			oldIpodetail.setRemarks(ipodetail.getRemarks());
			oldIpodetail.setOpendatetime(ipodetail.getOpendatetime());		
            this.ipodetailRepository.save(oldIpodetail);
            return ResponseResult.build(ResponseCode.SUCCESS, "SUCCESS!");
        } catch (Exception e) {
            return ResponseResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        } 
	}

	@Override
	public ResponseResult findIpodetailById(Integer id) {
		try {
			Ipodetail ipodetail = this.ipodetailRepository.findById(id);
            return ResponseResult.build(ResponseCode.SUCCESS, "SUCCESS!", ipodetail);
        } catch (Exception e) {
            return ResponseResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        }  
    }

}
