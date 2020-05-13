package com.fsd.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ipo_detail")
public class Ipodetail implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "company_name")
    private String companyname;
	
	@Column(name = "stock_exchange")
    private String stockexchange;
	
	@Column(name = "price_per_share")
    private BigDecimal pricepershare;
	
	@Column(name = "total_num")
    private int totalnum;
	
	@Column(name = "open_date_time")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp opendatetime;
	
	@Column(name = "remarks")
    private String remarks;

	public Ipodetail() {}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getStockexchange() {
		return stockexchange;
	}

	public void setStockexchange(String stockexchange) {
		this.stockexchange = stockexchange;
	}

	public BigDecimal getPricepershare() {
		return pricepershare;
	}

	public void setPricepershare(BigDecimal pricepershare) {
		this.pricepershare = pricepershare;
	}

	public int getTotalnum() {
		return totalnum;
	}

	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}

	public Timestamp getOpendatetime() {
		return opendatetime;
	}

	public void setOpendatetime(Timestamp opendatetime) {
		this.opendatetime = opendatetime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	

}
