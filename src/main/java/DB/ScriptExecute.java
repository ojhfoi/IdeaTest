package DB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for execute script from database
 */
@Component
@ComponentScan
public class ScriptExecute {

    /**
     * Take database connection from DBSource
     */
    private DataSource dataSource;

    private void execute(@Autowired DataSource dataSource){
       this.dataSource = dataSource;
    }

    /**
     * Execute script and take data from database
     * @param tag - enviroment from -D
     * @return return data
     * @throws SQLException
     */
    @Bean
    public String getData(String tag) throws SQLException {
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement select = connection.prepareStatement("select url from utest.testdata where tag='" +tag+"';");
            String res = String.valueOf(select);
            return res;
        }
    }

}
