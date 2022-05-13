package hackerton.server.Repository;

import hackerton.server.Model.RankUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RankUserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<RankUser> getAllRankUser() throws SQLException {
        String query = "select memberName, memberTotalScore from MEMBER ORDER BY memberTotalScore DESC";
        return this.jdbcTemplate.query(query,
                (rs, rowNum) -> new RankUser(
                        rs.getString("memberName"),
                        rs.getLong("memberTotalScore")
                ));
    }
}
