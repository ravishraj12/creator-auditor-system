package com.wibmo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wibmo.bean.MakerChecker;
import com.wibmo.dao.MCEngineDao;

@Service
public class MCEngineService {

	@Autowired
	private MCEngineDao makerCheckerDAO;

	public void storeData(MakerChecker makerChecker) throws JsonProcessingException {
		makerCheckerDAO.storeData(makerChecker);
	}

	public List<MakerChecker> getMakerCheckerInfo(String sqlQuery, Object[] params) {
		return makerCheckerDAO.getMakerCheckerInfo(sqlQuery, params);
	}

	public void updateData(String sqlQuery, Object[] params) throws JsonProcessingException {
		makerCheckerDAO.updateData(sqlQuery, params);
	}

}
