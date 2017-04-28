package com.inautix.mdsQuotetoolWeb.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.inautix.mdsQuotetoolWeb.bean.MdsQuotetoolWebOutputBean;

public class RowMapper implements
		org.springframework.jdbc.core.RowMapper<MdsQuotetoolWebOutputBean> {

	public MdsQuotetoolWebOutputBean mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		MdsQuotetoolWebOutputBean bean = new MdsQuotetoolWebOutputBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
		bean.setReportType(rs.getString(1));
		bean.setFromdt(rs.getString(2));
		bean.setTodate(rs.getString(3));
		bean.setProduct(rs.getString(4));
		bean.setStatus("Success");
		Date fromdt = null;
		try {
			fromdt = (Date) sdf.parse(rs.getString(2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date todate = null;
		try {
			todate = (Date) sdf.parse(rs.getString(3));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long diffInDays = (todate.getTime() - fromdt.getTime())
				/ (24 * 60 * 60 * 1000);
		bean.setDatediff(diffInDays);
		System.out.println(bean.getDatediff());
		return bean;
	}

}