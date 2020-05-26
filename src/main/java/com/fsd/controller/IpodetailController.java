package com.fsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.domain.Ipodetail;
import com.fsd.service.IpodetailService;
import com.fsd.util.ResponseResult;

@RestController
@RequestMapping("/ipodetail")
public class IpodetailController {
	
	@Autowired
	private IpodetailService ipodetailService;
	
	@GetMapping("/list")
    public ResponseResult queryIpodetailAll() {
        return ipodetailService.findAll();
    }
	
	@GetMapping("/list/{id}")
    public ResponseResult queryIpodetailById(@PathVariable Integer id){
        return ipodetailService.findIpodetailById(id);
    }
	
	@PostMapping
    public ResponseResult updateIpodetail(@RequestBody Ipodetail ipodetail){
        return ipodetailService.updateIpodetailById(ipodetail);
    }

}
