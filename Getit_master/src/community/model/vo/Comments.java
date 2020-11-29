package community.model.vo;

import java.sql.Date;

public class Comments {
	
	private int cNo;
	private String cContents;
	private Date cDate;
	private int qnaNo;
	private int review_no;
	private String memberId;
	
	public Comments() {}

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public String getcContents() {
		return cContents;
	}

	public void setcContents(String cContents) {
		this.cContents = cContents;
	}

	public Date getcDate() {
		return cDate;
	}

	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public int getReview_no() {
		return review_no;
	}

	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	

}
