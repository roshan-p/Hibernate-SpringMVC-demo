package web;
import javax.sql.*;
import java.util.*;
import org.springframework.orm.hibernate5.*;
import org.springframework.jdbc.datasource.*;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.*;
import org.springframework.beans.factory.annotation.*;

@Configuration
@EnableTransactionManagement
public class Hibernate {

	@Value("${hibernate.driver}")
	private String driver;

	@Value("${hibernate.password}")
	private String password;

	@Value("${hibernate.url}")
	private String url;

	@Value("${hibernate.username}")
	private String user;

	@Value("${hibernate.dialect}")
	private String dialect;

	@Value("${hibernate.packagesToScan}")
	private String folder;

	@Bean
	public DataSource buildDataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName(driver);
		source.setUrl(url);
		source.setUsername(user);
		source.setPassword(password);
		return source;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean session = new LocalSessionFactoryBean();
		session.setDataSource(buildDataSource());
		session.setPackagesToScan(folder);
		Properties hibernate = new Properties();
		hibernate.put("hibernate.dialect",      dialect);
		hibernate.put("hibernate.show_sql",     "false");
		hibernate.put("hibernate.hbm2ddl.auto", "false");
		session.setHibernateProperties(hibernate);
		return session;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager m = new HibernateTransactionManager();
		m.setSessionFactory(sessionFactory().getObject());
		return m;
	}
}
