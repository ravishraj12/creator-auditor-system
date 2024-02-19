package com.wibmo.bean;

public class ApiResponse {

    private String responseCode;
    private String responseDesc;
    private String errorCode;
    private String errorDesc;

    public ApiResponse(String responseCode, String responseDesc, String errorCode, String errorDesc) {
        this.responseCode = responseCode;
        this.responseDesc = responseDesc;
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseDesc() {
		return responseDesc;
	}

	public void setResponseDesc(String responseDesc) {
		this.responseDesc = responseDesc;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	
	@Override
	public String toString() {
		return "ApiResponse [responseCode=" + responseCode + ", responseDesc=" + responseDesc + ", errorCode="
				+ errorCode + ", errorDesc=" + errorDesc + "]";
	}
}

