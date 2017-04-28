package com.inautix.mdsQuotetoolWeb.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inautix.mdsQuotetoolWeb.bean.MdsQuotetoolWebInputBean;
import com.inautix.mdsQuotetoolWeb.bean.MdsQuotetoolWebOutputBean;
import com.inautix.mdsQuotetoolWeb.dao.MdsQuotetoolWebDao;

@RestController
@ComponentScan("com.inautix.mdsQuotetoolWeb")
public class MdsQuotetoolWebController {
	@Autowired
	private MdsQuotetoolWebDao mdsQuotetoolWebDao;

	@RequestMapping(value = "/quotelookup/get", method = RequestMethod.GET)
	public String restQuote() {
		return "WELCOME";
	}

	@RequestMapping(value = "/quotelookup/restQuote", method = RequestMethod.POST)
	public List<MdsQuotetoolWebOutputBean> restQuote(
			@RequestBody MdsQuotetoolWebInputBean msb) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
		Date fromdt = null;
		try {
			fromdt = (Date) sdf.parse(msb.getFromdt());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date todate = null;
		try {
			todate = (Date) sdf.parse(msb.getTodate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long diffInDays = (todate.getTime() - fromdt.getTime())
				/ (24 * 60 * 60 * 1000);
		//System.out.println(diffInDays);
		if (diffInDays < 0) {
			MdsQuotetoolWebOutputBean mdsQuotetoolWebOutputBean = new MdsQuotetoolWebOutputBean();
			mdsQuotetoolWebOutputBean.setStatus("Not valid input.");
			List<MdsQuotetoolWebOutputBean> list = new ArrayList<MdsQuotetoolWebOutputBean>();
			list.add(mdsQuotetoolWebOutputBean);
			return list;
		} else {
			return mdsQuotetoolWebDao.restQuote(msb);
		}

	}
}
