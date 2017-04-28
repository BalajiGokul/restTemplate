package com.inautix.mdsQuotetoolWeb.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.inautix.mdsQuotetoolWeb.bean.MdsQuotetoolWebInputBean;
import com.inautix.mdsQuotetoolWeb.bean.MdsQuotetoolWebOutputBean;
import com.inautix.mdsQuotetoolWeb.rowMapper.RowMapper;

@Component
public class MdsQuotetoolWebDao extends JdbcDaoSupport {

	@Autowired
	public MdsQuotetoolWebDao(DataSource dataSource) {
		setDataSource(dataSource);
	}

	public List<MdsQuotetoolWebOutputBean> restQuote(
			MdsQuotetoolWebInputBean msb) {
		return getJdbcTemplate().query(
				"select * from mds_quotetool_web where reportType = '"
						+ msb.getReportType() + "' and fromdt >= '"
						+ msb.getFromdt() + "' and todate <='"
						+ msb.getTodate() + "'and product = '"
						+ msb.getProduct() + "'", new Object[] {},
				new RowMapper());
	}

}