package com.inautix.mdsQuotetoolWeb.bean;

public class MdsQuotetoolWebOutputBean {

	private String reportType= "Invalid input date", fromdt= "Invalid input date", todate, product= "Invalid input date",
			status ;

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	long datediff = -1;

	public long getDatediff() {
		return datediff;
	}

	public void setDatediff(long l) {
		this.datediff = l;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getFromdt() {
		return fromdt;
	}

	public void setFromdt(String fromdt) {
		this.fromdt = fromdt;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

}
