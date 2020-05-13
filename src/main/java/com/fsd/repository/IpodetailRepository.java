package com.fsd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsd.domain.Ipodetail;

public interface IpodetailRepository extends JpaRepository<Ipodetail,Long>{
	
	Ipodetail findById(Integer id);
	
}
