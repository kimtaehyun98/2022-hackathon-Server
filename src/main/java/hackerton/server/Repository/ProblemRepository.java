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
						rs.getLong("userProblemId"),
						rs.getLong("memberId"),
						rs.getLong("problemId"),
						rs.getLong("score")
				),
				param
		);
	}
	
	public void insertUserProblem(int uid, int pid, int score){
		String query = "insert USER_PROBLEM VALUES (default, ?, ?, ?)";
		Object[] param = new Object[]{uid, pid, score};
		this.jdbcTemplate.update(query, param);

		query = "update MEMBER set memberSolveCnt = memberSolveCnt + 1 WHERE memberId = ?";
		this.jdbcTemplate.update(query, uid);
	}
	
	public void updateUserProblem(int uid, int pid, int score){
		String query = "update USER_PROBLEM set score = ? where memberId = ? and problemId = ?";
		Object[] param = new Object[]{score, uid, pid};
		this.jdbcTemplate.update(query, param);
	}
	
	public int getTopScore(int pid){
		String query = "select topScore from PROBLEM where problemId = ?";
		return this.jdbcTemplate.queryForObject(query, Integer.class, pid);
	}
	
	public void updateTopScore(int pid, int score, String name){
		String query = "update PROBLEM set topScore = ? , topMemberName = ? where problemId = ?";
		Object[] param = new Object[]{score, name, pid};
		this.jdbcTemplate.update(query, param);
	}
	
	public void createProblem(String name, String lang, String content, String tier, Boolean isTutorial){
		String query = "insert PROBLEM VALUES(default, ?, ?, ?, ?, 0, 0, ' ', ?)";
		Object[] param = new Object[]{name, lang, content, tier, isTutorial};
		this.jdbcTemplate.update(query, param);
	}
}
