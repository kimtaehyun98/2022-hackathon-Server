package hackerton.server.Repository;

import hackerton.server.Model.RankProblem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RankProblemRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<RankProblem> getAllRankProblem() throws SQLException {
        String query = "select problemId, topMemberName, topScore from PROBLEM ORDER BY topScore DESC";
        return this.jdbcTemplate.query(query,
                (rs, rowNum) -> new RankProblem(
                        rs.getLong("problemId"),
                        rs.getString("topMemberName"),
                        rs.getLong("topScore")
                )
        );
    }
}
