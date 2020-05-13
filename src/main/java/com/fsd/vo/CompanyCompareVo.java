package com.fsd.vo;

import java.util.List;

public class CompanyCompareVo {
	
	private String periodicity;
	
	private String fromdate;
	
	private String todate;
	
	private List companys;

	public String getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(String periodicity) {
		this.periodicity = periodicity;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public List getCompanys() {
		return companys;
	}

	public void setCompanys(List companys) {
		this.companys = companys;
	}
	
	

}
