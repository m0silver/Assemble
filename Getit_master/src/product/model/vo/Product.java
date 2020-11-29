package product.model.vo;

public class Product {
	
	private String pCode;
	private int serialNo;
	private String sepCode;
	private String pName;
	private int pPrice;
	private int pAccount;
	private String pContents;
	private String pCategory;
	private String pComcode;
	private String pFilename;
	private String pFilepath;
	private String relatedProduct;
	private String pcFilename;
	private String pcFilepath;
	
	public Product() {}

	
	public String getRelatedProduct() {
		return relatedProduct;
	}


	public void setRelatedProduct(String relatedProduct) {
		this.relatedProduct = relatedProduct;
	}


	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getSepCode() {
		return sepCode;
	}

	public void setSepCode(String sepCode) {
		this.sepCode = sepCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public int getpAccount() {
		return pAccount;
	}

	public void setpAccount(int pAccount) {
		this.pAccount = pAccount;
	}

	public String getpContents() {
		return pContents;
	}

	public void setpContents(String pContents) {
		this.pContents = pContents;
	}

	public String getpCategory() {
		return pCategory;
	}

	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}

	public String getpComcode() {
		return pComcode;
	}

	public void setpComcode(String pComcode) {
		this.pComcode = pComcode;
	}

	public String getpFilename() {
		return pFilename;
	}

	public void setpFilename(String pFilename) {
		this.pFilename = pFilename;
	}

	public String getpFilepath() {
		return pFilepath;
	}

	public void setpFilepath(String pFilepath) {
		this.pFilepath = pFilepath;
	}


	public String getPcFilename() {
		return pcFilename;
	}


	public void setPcFilename(String pcFilename) {
		this.pcFilename = pcFilename;
	}


	public String getPcFilepath() {
		return pcFilepath;
	}


	public void setPcFilepath(String pcFilepath) {
		this.pcFilepath = pcFilepath;
	}
}
