package hackerton.server.Service;

import hackerton.server.Model.UserProblem;
import hackerton.server.Repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemService {
	
	private final ProblemRepository problemRepository;
	
	@Autowired
	public ProblemService(ProblemRepository problemRepository) {
		this.problemRepository = problemRepository;
	}
	
	/**
	 * user가 문제를 두 번 이상 풀었는지 확인 후 DB 갱신
	 */
	public void checkSolve(int uid, int pid, int score){
		// 문제를 풀었었는지 검사
		List<UserProblem> userProblems = problemRepository.checkSolve(uid, pid);
		
		// 문제를 풀었었다면 update, 아니면 insert
		if(userProblems.isEmpty()){
			problemRepository.insertUserProblem(uid, pid, score);
		}
		else {
			problemRepository.updateUserProblem(uid, pid, score);
		}
	}
	
	public int getTopScore(int pid, int score){
		// 해당 문제의 최고 점수 가져옴
		int topScore = problemRepository.getTopScore(pid);
		// 최고 점수보다 높다면 update
		if(score > topScore){
			problemRepository.updateTopScore(pid, score);
		}
		return topScore;
	}
	
	public void createProblem(String name, String lang, String content, String tier, Boolean isTutorial){
		// 문제 생성
		problemRepository.createProblem(name, lang, content, tier, isTutorial);
	}
	
}
