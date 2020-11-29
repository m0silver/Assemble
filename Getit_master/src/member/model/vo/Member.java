package member.model.vo;

import java.sql.Date;

public class Member {
	
	private String memberId;
	private String email;
	private String memberName;
	private String memberPwd;
	private String phone;
	private String address;
	private String detailAddress;
	private String dob;
	private String gender;
	private Date enrollDate;
	private Date outDate;
	private String outYN;
	private String zipcode;
	
	
	
	public Member() {
		
	}



	public String getMemberId() {
		return memberId;
	}



	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getMemberName() {
		return memberName;
	}



	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}



	public String getMemberPwd() {
		return memberPwd;
	}



	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getDetailAddress() {
		return detailAddress;
	}



	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public Date getEnrollDate() {
		return enrollDate;
	}



	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}



	public Date getOutDate() {
		return outDate;
	}



	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}



	public String getOutYN() {
		return outYN;
	}



	public void setOutYN(String outYN) {
		this.outYN = outYN;
	}



	public String getZipcode() {
		return zipcode;
	}



	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
