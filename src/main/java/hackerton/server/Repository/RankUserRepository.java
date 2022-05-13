package hackerton.server.Repository;

import hackerton.server.Model.RankUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class RankUserRepository {

    private static final DataSourceConfig dataSourceConfig = new DataSourceConfig();
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceConfig.getDataSource());

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<RankUser> getAllRankUser() throws SQLException {
        String query = "select memberName, memberTotalScore from MEMBER";
        return this.jdbcTemplate.query(query,
                (rs, rowNum) -> new RankUser(
                        rs.getString("memberName"),
                        rs.getLong("memberTotalScore")
                ));
    }
}
