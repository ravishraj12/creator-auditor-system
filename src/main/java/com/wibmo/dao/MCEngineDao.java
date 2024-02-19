package com.wibmo.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wibmo.bean.MakerChecker;

@Repository
public class MCEngineDao {

	private static final Logger logger = LoggerFactory.getLogger(MCEngineDao.class);

	@Autowired
	private final JdbcTemplate jdbcTemplate;

	public MCEngineDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void storeData(MakerChecker makerChecker) {
		String sql = "INSERT INTO maker_checker_new (UUID, BANK_ID, PRODUCT_ID, MAKER_ID, MAKER_DATETIME, SCREEN_ID, "
				+ "CHECKER_ID, CHECKER_DATETIME, PREVIOUS_DATA_JSON, NEW_DATA_JSON, COMMENTS, STATUS, RELEASE_STATUS, "
				+ "RELEASE_DATETIME, ACTION, SCREEN_NAME, CONFIG_TYPE, CONFIG_CLASS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
				+ "?, ?, ?, ?, ?, ?, ?, ?)";
		logger.info("SQLQuery: {}", sql);
		jdbcTemplate.update(sql, makerChecker.getUuid(), makerChecker.getBankId(), makerChecker.getProductId(),
				makerChecker.getMakerId(), makerChecker.getMakerDate(), makerChecker.getScreenId(),
				makerChecker.getCheckerId(), makerChecker.getCheckerDate(), makerChecker.getPreviousDataJson(),
				makerChecker.getNewDataJson(), makerChecker.getComments(), makerChecker.getStatus(),
				makerChecker.getReleaseStatus(), makerChecker.getReleaseDate(), makerChecker.getEntityAction(),
				makerChecker.getScreenName(), makerChecker.getConfigType(), makerChecker.getConfigClass());
	}

	@SuppressWarnings("deprecation")
	public List<MakerChecker> getMakerCheckerInfo(String sqlQuery, Object[] params) {
		return jdbcTemplate.query(sqlQuery, params, (resultSet, rowNum) -> {

			MakerChecker makerChecker = new MakerChecker();
			makerChecker.setUuid(resultSet.getString("UUID"));
			makerChecker.setBankId(resultSet.getInt("BANK_ID"));
			makerChecker.setProductId(resultSet.getInt("PRODUCT_ID"));
			makerChecker.setMakerId(resultSet.getString("maker_id"));
			makerChecker.setMakerDate(resultSet.getString("MAKER_DATETIME"));
			makerChecker.setScreenId(resultSet.getInt("SCREEN_ID"));
			makerChecker.setCheckerId(resultSet.getString("CHECKER_ID"));
			makerChecker.setCheckerDate(resultSet.getString("CHECKER_DATETIME"));
			makerChecker.setPreviousDataJson(resultSet.getString("PREVIOUS_DATA_JSON"));
			makerChecker.setNewDataJson(resultSet.getString("NEW_DATA_JSON"));
			makerChecker.setComments(resultSet.getString("COMMENTS"));
			makerChecker.setStatus(resultSet.getString("STATUS"));
			makerChecker.setReleaseStatus(resultSet.getString("RELEASE_STATUS"));
			makerChecker.setReleaseDate(resultSet.getString("RELEASE_DATETIME"));
			makerChecker.setEntityAction(resultSet.getString("ACTION"));
			makerChecker.setScreenName(resultSet.getString("SCREEN_NAME"));
			makerChecker.setConfigType(resultSet.getString("CONFIG_TYPE"));
			makerChecker.setConfigClass(resultSet.getString("CONFIG_CLASS"));

			// Set other fields accordingly
			return makerChecker;
		});
	}

	public void updateData(String sqlQuery, Object[] params) {
		jdbcTemplate.update(sqlQuery, params);
	}
}
