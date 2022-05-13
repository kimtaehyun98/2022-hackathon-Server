package hackerton.server.Repository;

import hackerton.server.Model.GetMember;
import hackerton.server.Model.UserProblem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class MemberRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void createMember(String memberName, String memberEmail){
        String query = "insert MEMBER VALUES (?, ?, 0, 0)";
        Object[] param = new Object[]{memberName, memberEmail};
        this.jdbcTemplate.update(query, param);
    }

    public List<GetMember> getMember(String memberName){
        String query = "select * from MEMBER WHERE memberName = ?";
        Object[] param = new Object[]{memberName};
        return this.jdbcTemplate.query(query,
                (rs, rowNum) -> new GetMember(
                        rs.getString("memberName"),
                        rs.getString("memberEmail"),
                        rs.getInt("memberTotalScore"),
                        rs.getInt("memberSolveCnt")
                ),
                param
        );
    }

}
