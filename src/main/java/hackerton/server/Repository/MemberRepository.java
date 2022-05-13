package hackerton.server.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class MemberRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void createMember(Long memberId, String memberName, String memberEmail){
        String query = "insert MEMBER VALUES (?, ?, ?, 0, 0)";
        Object[] param = new Object[]{memberId, memberName, memberEmail};
        this.jdbcTemplate.update(query, param);
    }
}
