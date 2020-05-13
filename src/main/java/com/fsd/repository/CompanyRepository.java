package com.fsd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fsd.domain.Company;

public interface CompanyRepository extends JpaRepository<Company,Long>{

    Company findById(Integer id);

    @Query(name = "getByCompanycode", nativeQuery = true, value = "SELECT company_name from company where company_code = :companycode")
    String getByCompanycode(String companycode);
    
    @Query(value="SELECT CONVERT (t2.year_month_str, CHAR) AS time,IFNULL(avg(i.current_price), 0) AS company_price "
    		+ "FROM (SELECT @rownum \\:=@rownum + 1 AS num, date_format(DATE_SUB(now(), INTERVAL @rownum MONTH),'%Y-%m') AS year_month_str "
    		+ "FROM (SELECT @rownum \\:= - 1) AS r_init,(SELECT c.id FROM fsd.stock_price_detail c ) AS c_init) t2 "
    		+ "LEFT JOIN (select spd.id,spd.stock_exchange,current_price,date,time,com.company_name from fsd.stock_price_detail spd,fsd.company com "
    		+ "where spd.company_code = com.company_code and company_name=:companyname and stock_exchange=:stockexchange) "
    		+ " AS i ON (CONCAT(DATE_FORMAT(i.date, '%Y'),'-',DATE_FORMAT(i.date, '%m')) = t2.year_month_str) " 
    		+ "WHERE t2.year_month_str BETWEEN :fromdate AND :todate "
    		+ "GROUP BY t2.year_month_str ORDER BY time ",nativeQuery = true)
    List getChartByMonth(@Param("companyname") String companyname,@Param("stockexchange") String stockexchange,@Param("fromdate") String fromdate,@Param("todate") String todate);



}