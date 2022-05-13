package hackerton.server.Controller;

import hackerton.server.Model.Problems.PostScoreReq;
import hackerton.server.Repository.ProblemRepository;
import hackerton.server.Service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/problem")
public class ProblemController {

	private final ProblemRepository problemRepository;
	private final ProblemService problemService;
	
	@Autowired
	public ProblemController(ProblemRepository problemRepository, ProblemService problemService) {
		this.problemRepository = problemRepository;
		this.problemService = problemService;
	}
	
	@PostMapping
	public void countScore(@RequestBody PostScoreReq postProblemReq){
		problemService.checkSolve(postProblemReq.getMemberId(), postProblemReq.getProblemId(), postProblemReq.getScore());
		problemService.getTopScore(postProblemReq.getProblemId(), postProblemReq.getScore());
	}
	
	@PostMapping("/setProblem")
	public void createProblem(@RequestBody hackerton.server.Model.Problems.PostCreateReq postCreateReq){
	
	}
}
