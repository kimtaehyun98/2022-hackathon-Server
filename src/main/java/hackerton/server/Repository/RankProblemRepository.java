package hackerton.server.Repository;

import hackerton.server.Model.RankProblem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class RankProblemRepository {

    private static final DataSourceConfig dataSourceConfig = new DataSourceConfig();
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceConfig.getDataSource());

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<RankProblem> getAllRankProblem() throws SQLException {
        String query = "select problemID, topMemberName, topScore from PROBLEM";
        return this.jdbcTemplate.query(query,
                (rs, rowNum) -> new RankProblem(
                        rs.getLong("problemId"),
                        rs.getString("topMemberName"),
                        rs.getLong("topScore")
                ));
    }
}
