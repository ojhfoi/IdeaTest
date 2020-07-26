package DB;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * Database connection class
 */

@Configuration
@ComponentScan
public class DBSource {

    /**
     * Database connection configuration
     * @return connection
     */
    @Bean
    @Scope("singleton")
    public DataSource dataSource(){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("ojhfoi");
        dataSource.setPassword("48362512");
        dataSource.setUser("jdbc:mysql://localhost:3306/utest");
        return dataSource;
    }

}
