package com.inautix.mdsQuotetoolWeb.App;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;

/*@JsonRootName(value = "quoteRequest")
@XmlRootElement(name="quoteRequest")
@XmlType(propOrder = { "siteId","customerId","networkId","qtChrgInd","qtRqstType","quoteInd","correspondentnum","qtBitMask","sendDlOnFailInd","repeated"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuoteRequest implements Serializable {
	private  final long serialVersionUID = 1L;	

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public char getNetworkId() {
		return networkId;
	}

	public void setNetworkId(char networkId) {
		this.networkId = networkId;
	}

	

	public char getQtChrgInd() {
		return qtChrgInd;
	}

	public void setQtChrgInd(char qtChrgInd) {
		this.qtChrgInd = qtChrgInd;
	}

	
	public String getQtRqstType() {
		return qtRqstType;
	}

	public void setQtRqstType(String qtRqstType) {
		this.qtRqstType = qtRqstType;
	}
	
	@JsonIgnore
	public char getQuoteInd() {
		return quoteInd;
	}

	public void setQuoteInd(char quoteInd) {
		this.quoteInd = quoteInd;
	}

	public String getCorrespondentNum() {
		return correspondentNum;
	}

	public void setCorrespondentNum(String correspondentNum) {
		this.correspondentNum = correspondentNum;
	}

	
	
	public int getQtBitMask() {
		return qtBitMask;
	}

	public void setQtBitMask(int qtBitMask) {
		this.qtBitMask = qtBitMask;
	}

	public Character getSendDlOnFailInd() {
		return sendDlOnFailInd;
	}

	public void setSendDlOnFailInd(Character sendDlOnFailInd) {
		this.sendDlOnFailInd = sendDlOnFailInd;
	}

	

	public int getItemCnt() {
		return itemCnt;
	}

	public void setItemCnt(int itemCnt) {
		this.itemCnt = itemCnt;
	}



	public List<RepeatedFields> getRepeated() {
		return repeated;
	}

	public void setRepeated(List<RepeatedFields> repeated) {
		this.repeated = repeated;
	}

	

	String siteId;
	String customerId;
	char networkId=' ';
	char qtChrgInd=' ';
	String qtRqstType;
	char quoteInd=' ';
	String correspondentNum;
	int qtBitMask;
	Character sendDlOnFailInd=' ';
	int itemCnt;





	
	public List<RepeatedFields> repeated=new ArrayList<QuoteRequest.RepeatedFields>();

	@XmlType(propOrder = {"symId","blockCount"})
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class RepeatedFields implements Serializable{
		private static final long serialVersionUID = 1L;
		String symId;
		int blockCount;
		

		public int getBlockCount() {
			return blockCount;
		}

		public void setBlockCount(int blockCount) {
			this.blockCount = blockCount;
		}
		public String getSymId() {
			return symId;
		}

		public void setSymId(String symid) {
			this.symId = symid;
		}
	}

}

*/
/*
@JsonRootName(value = "quoteRequest")
@XmlRootElement(name="quoteRequest")
@XmlType(propOrder = { "siteId","customerId","networkId","qtChrgInd","qtRqstType","quoteInd","correspondentnum","qtBitMask","sendDlOnFailInd","repeated"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuoteRequest implements Serializable {
	private  final long serialVersionUID = 1L;
	int id,age;
	String name,gender;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	
	
}
*/



@SuppressWarnings({ "restriction", "serial" })
@JsonRootName(value = "quoteRequest")
@XmlRootElement(name="quoteRequest")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuoteRequest implements Serializable {
	private String reportType,product,fromdt,todate;
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
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
	
	
}
