package hackerton.server.Repository;

import hackerton.server.Model.Script;
import hackerton.server.Model.UserProblem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScriptRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Script> getTutorials() throws SQLException {
        String query = "select * from PROBLEM";
        return this.jdbcTemplate.query(query,
                (rs, rowNum) -> new Script(
                        rs.getInt("problemId"),
                        rs.getString("madeUserName"),
                        rs.getString("language"),
                        rs.getString("content"),
                        rs.getString("tier"),
                        rs.getInt("topScore"),
                        rs.getString("topMemberName"),
                        rs.getInt("likes")
                )
        );
    }

    public List<Script> getUsers() throws SQLException {
        String query = "select * from PROBLEM where isTutorial = false";
        return this.jdbcTemplate.query(query,
                (rs, rowNum) -> new Script(
                        rs.getInt("problemId"),
                        rs.getString("madeUserName"),
                        rs.getString("language"),
                        rs.getString("content"),
                        rs.getString("tier"),
                        rs.getInt("topScore"),
                        rs.getString("topMemberName"),
                        rs.getInt("likes")
                )
        );
    }
}
