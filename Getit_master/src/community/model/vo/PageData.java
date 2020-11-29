package community.model.vo;

import java.util.ArrayList;

public class PageData {
	private ArrayList<Review> pageList;
	private ArrayList<Comments> pageComList;
	private String pageReNavi;
	private String pageComNavi;
	
	public PageData() {}

	public ArrayList<Review> getPageList() {
		return pageList;
	}

	public void setPageList(ArrayList<Review> pageList) {
		this.pageList = pageList;
	}

	public String getPageReNavi() {
		return pageReNavi;
	}

	public void setPageReNavi(String pageNavi) {
		this.pageReNavi = pageNavi;
	}

	public ArrayList<Comments> getPageComList() {
		return pageComList;
	}

	public void setPageComList(ArrayList<Comments> pageComList) {
		this.pageComList = pageComList;
	}

	public String getPageComNavi() {
		return pageComNavi;
	}

	public void setPageComNavi(String pageComNavi) {
		this.pageComNavi = pageComNavi;
	}
}
