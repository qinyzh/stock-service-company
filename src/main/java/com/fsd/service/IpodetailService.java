package com.fsd.service;

import com.fsd.domain.Ipodetail;
import com.fsd.util.ResponseResult;

public interface IpodetailService {
	
	ResponseResult findAll();
	ResponseResult findIpodetailById(Integer id);
	ResponseResult updateIpodetailById(Ipodetail ipodetail);

}
