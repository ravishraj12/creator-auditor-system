package com.wibmo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MakerChecker implements Serializable {

	private static final long serialVersionUID = 1L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String uuid;

	private Integer bankId;
	private int productId;
	private String productCode;
	private int screenId;

	private String previousDataJson;
	private String newDataJson;
	private String status;
	private String makerId;
	private String checkerId;
	private String comments;
	private String makerDate;
	private String checkerDate;
	private String releaseStatus;
	private String releaseDate;
	private String entityAction;
	private String screenName;
	private String configType;
	private String configClass;

	@JsonProperty("bank_id")
	@JsonAlias({"bank_id", "BANK_ID", "bankId", "BANKID"})
	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@JsonProperty("product_id")
	@JsonAlias({"product_id", "PRODUCT_ID", "productId", "PRODUCTID"})
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@JsonProperty("productCode")
	public String getProductCode() {
		return productCode;
	}

	@JsonProperty("productCode")
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@JsonProperty("screen_id")
	@JsonAlias({"screen_id", "SCREEN_ID", "screenId", "SCREENID"})
	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	@JsonProperty("previousDataJson")
	public String getPreviousDataJson() {
		return previousDataJson;
	}

	@JsonProperty("previousDataJson")
	public void setPreviousDataJson(String previousDataJson) {
		this.previousDataJson = previousDataJson;
	}

	@JsonProperty("newDataJson")
	public String getNewDataJson() {
		return newDataJson;
	}

	@JsonProperty("newDataJson")
	public void setNewDataJson(String newDataJson) {
		this.newDataJson = newDataJson;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("user_id")
	@JsonAlias({"user_id", "USER_ID", "userId", "USERID"})
	public String getMakerId() {
		return makerId;
	}

	public void setMakerId(String makerId) {
		this.makerId = makerId;
	}

	@JsonProperty("checker_id")
	@JsonAlias({"checker_id", "CHECKER_ID", "checkerId", "CHECKERID"})
	public String getCheckerId() {
		return checkerId;
	}

	public void setCheckerId(String checkerId) {
		this.checkerId = checkerId;
	}

	@JsonProperty("comment")
	public String getComments() {
		return comments;
	}

	@JsonProperty("comment")
	public void setComments(String comments) {
		this.comments = comments;
	}

	@JsonProperty("makerDate")
	public String getMakerDate() {
		return makerDate;
	}

	@JsonProperty("makerDate")
	public void setMakerDate(String makerDate) {
		this.makerDate = makerDate;
	}

	@JsonProperty("checkerDate")
	public String getCheckerDate() {
		return checkerDate;
	}

	@JsonProperty("checkerDate")
	public void setCheckerDate(String checkerDate) {
		this.checkerDate = checkerDate;
	}

	@JsonProperty("releaseStatus")
	public String getReleaseStatus() {
		return releaseStatus;
	}

	@JsonProperty("releaseStatus")
	public void setReleaseStatus(String releaseStatus) {
		this.releaseStatus = releaseStatus;
	}

	@JsonProperty("releaseDate")
	public String getReleaseDate() {
		return releaseDate;
	}

	@JsonProperty("releaseDate")
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	@JsonProperty("action")
	public String getEntityAction() {
		return entityAction;
	}

	@JsonProperty("action")
	public void setEntityAction(String entityAction) {
		this.entityAction = entityAction;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getConfigType() {
		return configType;
	}

	public void setConfigType(String configType) {
		this.configType = configType;
	}

	public String getConfigClass() {
		return configClass;
	}

	public void setConfigClass(String configClass) {
		this.configClass = configClass;
	}

	@Override
	public String toString() {
		return "MakerChecker [" + " bankId=" + bankId + ", productId=" + productId + ", productCode=" + productCode
				+ ", screenId=" + screenId + ", previousDataJson=" + previousDataJson + ", newDataJson=" + newDataJson
				+ ", status=" + status + ", makerId=" + makerId + ", checkerId=" + checkerId + ", comments=" + comments
				+ ", makerDate=" + makerDate + ", checkerDate=" + checkerDate + ", releaseStatus=" + releaseStatus
				+ ", releaseDate=" + releaseDate + ", entityAction=" + entityAction + ", screenName=" + screenName
				+ ", configType=" + configType + ", configClass=" + configClass + "]";
	}
}
