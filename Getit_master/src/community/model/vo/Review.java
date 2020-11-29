package community.model.vo;

import java.sql.Date;

public class Review {
	private int reviewNo;
	private String rTitle;
	private String rContents;
	private Date rDate;
	private String memberId;
	private String rFilename;
	private String rFilepath;
	private int viewCnt;
	
	public Review() {}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getrTitle() {
		return rTitle;
	}

	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}

	public String getrContents() {
		return rContents;
	}

	public void setrContents(String rContents) {
		this.rContents = rContents;
	}

	public Date getrDate() {
		return rDate;
	}

	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getrFilename() {
		return rFilename;
	}

	public void setrFilename(String rFilename) {
		this.rFilename = rFilename;
	}

	public String getrFilepath() {
		return rFilepath;
	}

	public void setrFilepath(String rFilepath) {
		this.rFilepath = rFilepath;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
}
