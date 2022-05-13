package hackerton.server.Repository;

import hackerton.server.Model.Script;
import hackerton.server.Model.UserProblem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScriptRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Script> getTutorials(String lan) throws SQLException {
        String query;
        if(lan.equals("한국어")) query = "select * from PROBLEM WHERE isTutorial = true and `language` != 'ENGLISH'";
        else query = "select * from PROBLEM WHERE isTutorial = true and `language` = 'ENGLISH'";
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

    public List<Script> getUsers(String lan) throws SQLException {
        String query;
        System.out.println(lan);
        if(lan.equals("한국어")) query = "select * from PROBLEM WHERE isTutorial = false and `language` != 'ENGLISH'";
        else query = "select * from PROBLEM WHERE isTutorial = false and `language` = 'ENGLISH'";
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
