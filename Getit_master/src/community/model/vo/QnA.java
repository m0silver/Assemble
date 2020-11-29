package community.model.vo;

import java.sql.Date;

public class QnA {

	private int qnaNo;
	private String qnaTitle;
	private String qnaContents;
	private Date qnaDate;
	private String memberId;
	private int fix;
	public QnA() {}
	
	
	public int getFix() {
		return fix;
	}
	public void setFix(int fix) {
		this.fix = fix;
	}
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContents() {
		return qnaContents;
	}
	public void setQnaContents(String qnaContents) {
		this.qnaContents = qnaContents;
	}
	public Date getQnaDate() {
		return qnaDate;
	}
	public void setQnaDate(Date qnaDate) {
		this.qnaDate = qnaDate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
}
