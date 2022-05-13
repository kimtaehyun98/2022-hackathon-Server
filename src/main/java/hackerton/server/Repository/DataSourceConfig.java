package hackerton.server.Repository;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://hackerton.crbgme9xcnaf.ap-northeast-2.rds.amazonaws.com:3306/hackerton");
        dataSourceBuilder.username("admin");
        dataSourceBuilder.password("hackerton!");
        return dataSourceBuilder.build();
    }
}