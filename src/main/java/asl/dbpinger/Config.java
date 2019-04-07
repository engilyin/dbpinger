package asl.dbpinger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class Config {

	@Value("${dataSource.jdbcDriver}")
	String dataSourceJdbcDriver;
	
	@Value("${dataSource.url}")
	String dataSourceUrl;

	@Value("${dataSource.username}")
	String dataSourceUsername;

	@Value("${dataSource.password}")
	String dataSourcePassword;
	
	@Value("${pinger.query}")
	String pingQuery;
	
	@Value("${pinger.scheduledRate}")
	String scheduledRate;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dataSourceJdbcDriver);
		dataSource.setUrl(dataSourceUrl);
		dataSource.setUsername(dataSourceUsername);
		dataSource.setPassword(dataSourcePassword);

		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	public String getPingQuery() {
		return pingQuery;
	}

	public String getScheduledRate() {
		return scheduledRate;
	}

	
}
