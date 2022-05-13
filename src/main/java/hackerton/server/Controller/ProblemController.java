package hackerton.server.Controller;

import hackerton.server.Model.Problem.PostScoreReq;
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
		problemService.checkSolve(postProblemReq);
		problemService.getTopScore(postProblemReq.getProblemId());
	}
	
	@PostMapping("/setProblem")
	public void createProblem(){
	
	}
}
