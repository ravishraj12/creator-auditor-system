package com.wibmo.bean;

import java.io.Serializable;

public class PreviousDataJson implements Serializable {

	private static final long serialVersionUID = 1L;
	public int bankId;
	public String user;
	public String maskedPan;
	public String acsTxnId;
	public String action;
	public String type;
	public String accountNumber;
	public int accountIdentifier;
	public String primaryPhNumber;
	public String primaryPhCountryCode;
	public String comment;

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMaskedPan() {
		return maskedPan;
	}

	public void setMaskedPan(String maskedPan) {
		this.maskedPan = maskedPan;
	}

	public String getAcsTxnId() {
		return acsTxnId;
	}

	public void setAcsTxnId(String acsTxnId) {
		this.acsTxnId = acsTxnId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountIdentifier() {
		return accountIdentifier;
	}

	public void setAccountIdentifier(int accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}

	public String getPrimaryPhNumber() {
		return primaryPhNumber;
	}

	public void setPrimaryPhNumber(String primaryPhNumber) {
		this.primaryPhNumber = primaryPhNumber;
	}

	public String getPrimaryPhCountryCode() {
		return primaryPhCountryCode;
	}

	public void setPrimaryPhCountryCode(String primaryPhCountryCode) {
		this.primaryPhCountryCode = primaryPhCountryCode;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
