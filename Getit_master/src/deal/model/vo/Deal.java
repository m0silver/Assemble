package deal.model.vo;

import java.sql.Date;

public class Deal {
	
	private int dealNo;
	private String dealTitle;
	private String dealContents;
	private int dealPrice;
	private Date dealDate;
	private String dealFileName;
	private String dealFilePath;
	private String memberId;
	
	public Deal() {}

	public int getDealNo() {
		return dealNo;
	}
	public void setDealNo(int dealNo) {
		this.dealNo = dealNo;
	}

	
	public String getDealTitle() {
		return dealTitle;
	}
	public void setDealTitle(String dealTitle) {
		this.dealTitle = dealTitle;
	}

	
	public String getDealContents() {
		return dealContents;
	}
	public void setDealContents(String dealContents) {
		this.dealContents = dealContents;
	}

	
	public int getDealPrice() {
		return dealPrice;
	}
	public void setDealPrice(int dealPrice) {
		this.dealPrice = dealPrice;
	}

	
	public Date getDealDate() {
		return dealDate;
	}
	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}
	
	
	public String getDealFileName() {
		return dealFileName;
	}
	public void setDealFileName(String dealFileName) {
		this.dealFileName = dealFileName;
	}

	public String getDealFilePath() {
		return dealFilePath;
	}
	public void setDealFilePath(String dealImageName) {
		this.dealFilePath = dealImageName;
	}

	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "Deal [dealNo=" + dealNo + ", dealTitle=" + dealTitle + ", dealContents=" + dealContents + ", dealPrice="
				+ dealPrice + ", dealDate=" + dealDate + ", dealFileName=" + dealFileName
				+ ", dealFilePath=" + dealFilePath + ", memberId=" + memberId + "]";
	}

	
	
	
}
