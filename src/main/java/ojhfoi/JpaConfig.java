package ojhfoi;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
//@EnableJpaRepositories({ "DB.service" })
@ComponentScan(basePackages = "DB")
@EnableTransactionManagement(mode= AdviceMode.ASPECTJ)
public class JpaConfig {

    private LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean;

    @Bean
        public EntityManagerFactory entityManagerFactory(){
            LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
            entityManagerFactoryBean.setDataSource(entityManagerFactoryBean.getDataSource());
            entityManagerFactoryBean.setPackagesToScan("ojhfoi");
            entityManagerFactoryBean.setPersistenceUnitName("test");
            HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
            hibernateJpaVendorAdapter.setShowSql(false);
            hibernateJpaVendorAdapter.setGenerateDdl(true);
            hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
            entityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
            entityManagerFactoryBean.afterPropertiesSet();
            return entityManagerFactoryBean.getObject();
        }

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource ds = new SimpleDriverDataSource();
        ds.setDriverClass(com.mysql.cj.jdbc.Driver.class);

        // Connection settings
        ds.setUrl("jdbc:mysql://localhost:3306/utest");
        ds.setUsername("ojhfoi");
        ds.setPassword("48362512");

        return ds;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        return transactionManager;
    }
}
