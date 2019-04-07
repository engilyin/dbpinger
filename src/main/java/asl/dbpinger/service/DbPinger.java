package asl.dbpinger.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import asl.dbpinger.Config;

@Service
public class DbPinger {

	private static final Logger log = LoggerFactory.getLogger(DbPinger.class);

	@Autowired
	Config config;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Scheduled(fixedRateString = "${pinger.scheduledRate}")
	public void pingDb() {
		try {
			List<Map<String, Object>> result = jdbcTemplate.queryForList(config.getPingQuery());
			log.info(String.format("Ping query returns: %d rows", result.size()));
		} catch (Throwable e) {
			log.error("Unable to execute ping DB query!", e);
		}
	}
}
