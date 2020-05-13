package com.fsd.util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DateUtil {
	
	/**
	 * cutDate
	 * @param periodicity--day/week/month/quarter/year
	 * @param fromdate
	 * @param todate
	 * @return
	 */
	public static List<String> cutDate(String periodicity, String fromdate, String todate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = (Date) sdf.parse(fromdate);
            Date endDate = (Date) sdf.parse(todate);
            
            return findDates(periodicity, startDate, endDate);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
	
	
	public static List<String> findDates(String dateType, Date startDate, Date endDate) throws Exception {
        List<String> listDate = new ArrayList<>();
        Calendar calStart = Calendar.getInstance();
        calStart.setTime(startDate);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(endDate);
        while (calEnd.after(calStart)) {
            switch (dateType) {
            	//seperated by week
                case "0":
                	calStart.add(Calendar.WEEK_OF_MONTH, 1);
                    break;
                //seperated by month
                case "1":
                	calStart.add(Calendar.MONTH, 1);break;
                //seperated by quarter
                case "2":
                	calStart.add(3*Calendar.MONTH, 1);break;
                //seperated by year    
                case "3":
                	calStart.add(Calendar.YEAR, 1);break;
            }
            if (calEnd.after(calStart))
                listDate.add(new SimpleDateFormat("yyyy-MM-dd").format(calStart.getTime()));
            else
                listDate.add(new SimpleDateFormat("yyyy-MM-dd").format(calEnd.getTime()));
        }
        return listDate;
    }

}
