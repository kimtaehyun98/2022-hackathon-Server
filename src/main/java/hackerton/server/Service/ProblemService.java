package hackerton.server.Service;

import hackerton.server.Model.Problems.PostCreateReq;
import hackerton.server.Model.Problems.PostScoreReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProblemService {
	
	private final ProblemService problemService;
	
	@Autowired
	public ProblemService(ProblemService problemService) {
		this.problemService = problemService;
	}
	
	/**
	 * user가 문제를 두 번 이상 풀었는지 확인 후 DB 갱신
	 */
	public void checkSolve(PostScoreReq req){
		// 문제를 풀었었는지 검사
		// 문제를 풀었었다면 update, 아니면 insert
		
	}
	
	public void getTopScore(int pid){
		// 해당 문제의 최고 점수 가져옴
		// 최고 점수보다 높다면 update
	}
	
	public void createProblem(PostCreateReq req){
		// 문제 생성
	}
	
}
