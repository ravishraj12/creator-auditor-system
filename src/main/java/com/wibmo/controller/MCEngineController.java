package com.wibmo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wibmo.bean.ApiResponse;
import com.wibmo.bean.MakerChecker;
import com.wibmo.service.MCEngineService;

@RestController
@RequestMapping("/api")
public class MCEngineController {

	@Autowired
	private MCEngineService mcEngineService;

	private static final Logger logger = LoggerFactory.getLogger(MCEngineController.class);

	@PostMapping(value = "/storeData", consumes = "application/json")
	public ApiResponse storeData(@RequestBody MakerChecker makerChecker) throws JsonProcessingException {
		
		logger.info("Store data Request payload: {}",makerChecker.toString());
		ApiResponse storeDataResp;
		int productId = 0;
		int screenId = 0;
		screenId = makerChecker.getScreenId();
		productId = makerChecker.getProductId();
		MakerChecker newMakerChecker = new MakerChecker();
		newMakerChecker.setUuid(UUID.randomUUID().toString());
		newMakerChecker.setBankId(makerChecker.getBankId());
		newMakerChecker.setProductId(productId);
		newMakerChecker.setMakerId(makerChecker.getMakerId());
		newMakerChecker.setMakerDate(LocalDateTime.now().toString());
		newMakerChecker.setScreenId(screenId);
		newMakerChecker.setCheckerId(makerChecker.getCheckerId());
		newMakerChecker.setCheckerDate(LocalDateTime.now().toString());
		newMakerChecker.setPreviousDataJson(makerChecker.getPreviousDataJson());
		newMakerChecker.setNewDataJson(makerChecker.getNewDataJson());
		newMakerChecker.setStatus(makerChecker.getStatus());
		newMakerChecker.setReleaseStatus(null);
		newMakerChecker.setReleaseDate(null);
		newMakerChecker.setEntityAction(makerChecker.getEntityAction());
		newMakerChecker.setScreenName(null);
		newMakerChecker.setConfigType(null);
		newMakerChecker.setConfigClass(null);
		logger.info("maker Checker object: {}",newMakerChecker.toString());
		try {
			mcEngineService.storeData(newMakerChecker);
			storeDataResp = new ApiResponse("00", "SUCCESSFUL", "", "");
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Error in storing data to db: {}",ex.getMessage());
			storeDataResp = new ApiResponse("01", "FAILURE", "01", "Error in storing data to DB");
		}
		return storeDataResp;
	}

	@PostMapping("/fetchData")
	public List<MakerChecker> fetchData(@RequestBody MakerChecker makerChecker) {

		logger.info("Fetch data Request payload: {}",makerChecker.toString());

		String[] status;
		String sqlQuery;
		if (makerChecker.getStatus() != null) {
			status = makerChecker.getStatus().split(",");
			StringBuilder sb = new StringBuilder();
			for (int st = 0; st < status.length; st++) {

				if (st < status.length - 1) {
					sb.append("\"");
					sb.append(status[st]);
					sb.append("\"");
					sb.append(",");
				} else {
					sb.append("\"");
					sb.append(status[st]);
					sb.append("\"");
				}
			}
			sqlQuery = "SELECT * FROM maker_checker_new where PRODUCT_ID = ? and SCREEN_ID = ? and STATUS in ("
					+ sb.toString() + ")";
		} else {
			sqlQuery = "SELECT * FROM maker_checker_new where PRODUCT_ID = ? and SCREEN_ID = ?";
		}
		
		// You can add parameters if needed
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(makerChecker.getProductId());
		paramsList.add(makerChecker.getScreenId());
		
		if(makerChecker.getBankId()!=null ){
			int bankId= makerChecker.getBankId();
			sqlQuery = sqlQuery + " and BANK_ID = ?";
			paramsList.add(bankId);
		}
		logger.info("fetch data SQLQuery: {}",sqlQuery);
		Object[] params = paramsList.toArray(new Object[0]);
		List<MakerChecker> fetchDataResp;
		try {
			fetchDataResp = mcEngineService.getMakerCheckerInfo(sqlQuery, params);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Error in fetching data from db: {}",ex.getMessage());
			fetchDataResp = null;
		}
		return fetchDataResp;
	}

	@PostMapping("/updateStatus")
	public ApiResponse updateStatus(@RequestBody MakerChecker makerChecker) throws JsonProcessingException {

		logger.info("Update Status Request payload: {}",makerChecker.toString());

		String sqlQuery = "update maker_checker_new " + "set STATUS = ?, " + "CHECKER_ID = ?,  "
				+ "CHECKER_DATETIME = ?," + "COMMENTS = ?" + " where UUID = ? ";
		logger.info("update status SQLQuery: {}",sqlQuery);
		List<Object> paramsList = new ArrayList<>();
		ApiResponse updateStatusResp;
		paramsList.add(makerChecker.getStatus());
		paramsList.add(makerChecker.getCheckerId());
		paramsList.add(LocalDateTime.now().toString());
		paramsList.add(makerChecker.getComments());
		paramsList.add(makerChecker.getUuid());
		Object[] params = paramsList.toArray(new Object[0]);

		try {
			mcEngineService.updateData(sqlQuery, params);
			updateStatusResp = new ApiResponse("00", "SUCCESSFUL", "", "");
		} catch (Exception ex) {
			logger.error("Error in update status : {}",ex.getMessage());
			updateStatusResp = new ApiResponse("01", "FAILURE", "01", "Error in updating status");
		}
		return updateStatusResp;
	}

	@GetMapping("/status")
	public ApiResponse Starter() {
		return new ApiResponse("00", "SUCCESSFUL", "", "");
	}
}
