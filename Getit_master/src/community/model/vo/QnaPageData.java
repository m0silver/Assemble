package community.model.vo;

import java.util.ArrayList;

public class QnaPageData {
	
	private ArrayList<QnA> qnaList;
	private String pageNavi;
	private ArrayList<Comments> comList;
	
	public QnaPageData() {}

	public ArrayList<QnA> getQnaList() {
		return qnaList;
	}

	public void setQnaList(ArrayList<QnA> qnaList) {
		this.qnaList = qnaList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	public ArrayList<Comments> getComList() {
		return comList;
	}

	public void setComList(ArrayList<Comments> comList) {
		this.comList = comList;
	}
	
	
	

}
