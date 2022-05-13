package hackerton.server.Repository;

import hackerton.server.Model.UserProblem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProblemRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<UserProblem> checkSolve(int uid, int pid){
		String query = "select * from USER_PROBLEM where memberId = ? and problemId = ?";
		Object[] param = new Object[]{uid, pid};
		return this.jdbcTemplate.query(query,
				(rs, rowNum) -> new UserProblem(
						rs.getLong("userProbelmId"),
						rs.getLong("memberId"),
						rs.getLong("problemId"),
						rs.getLong("score")
				),
				param
		);
	}
}
