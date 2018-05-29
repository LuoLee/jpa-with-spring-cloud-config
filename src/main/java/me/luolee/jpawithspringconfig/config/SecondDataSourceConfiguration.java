package me.luolee.jpawithspringconfig.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "secondEntityManager",
		transactionManagerRef = "secondTransactionManager",
		basePackages = "me.luolee.jpawithspringconfig.dao.sec"
)
public class SecondDataSourceConfiguration {

	/**
	 * MySQL datasource definition.
	 *
	 * @return datasource.
	 */
	@Bean
	@ConfigurationProperties(prefix = "datasource.second")
	public DataSource secondDataSource() {
		return DataSourceBuilder
					.create()
					.build();
	}

	/**
	 * Entity manager definition.
	 *
	 * @param builder an EntityManagerFactoryBuilder.
	 * @return LocalContainerEntityManagerFactoryBean.
	 */
	@Bean(name = "secondEntityManager")
	public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder
					.dataSource(secondDataSource())
					.packages("me.luolee.jpawithspringconfig.entity.sec")
					.build();
	}

	/**
	 * @param entityManagerFactory
	 * @return
	 */
	@Bean(name = "secondTransactionManager")
	public PlatformTransactionManager secondTransactionManager(@Qualifier("secondEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
