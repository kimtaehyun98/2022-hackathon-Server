package hackerton.server.Controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import hackerton.server.Model.Problems.PostCreateReq;
import hackerton.server.Model.Problems.PostScoreReq;
import hackerton.server.Model.Problems.PostScoreRes;
import hackerton.server.Repository.ProblemRepository;
import hackerton.server.Service.ProblemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/problem")
@Slf4j
public class ProblemController {

	private final ProblemRepository problemRepository;
	private final ProblemService problemService;
	
	@Autowired
	public ProblemController(ProblemRepository problemRepository, ProblemService problemService) {
		this.problemRepository = problemRepository;
		this.problemService = problemService;
	}
	
	@PostMapping
	public PostScoreRes countScore(@RequestBody PostScoreReq postProblemReq){
		problemService.checkSolve(postProblemReq.getMemberId(), postProblemReq.getProblemId(), postProblemReq.getScore());
		int topScore = problemService.getTopScore(postProblemReq.getProblemId(), postProblemReq.getScore(), postProblemReq.getMemberName());
		
		log.info("topScore : {}", topScore);
		log.info("name : {}", postProblemReq.getMemberName());
		
		PostScoreRes res = new PostScoreRes();
		int score = postProblemReq.getScore();
		
		// topScore가 갱신되지 않았으면 -1
		if(topScore < score) res.setTopScore(score);
		else res.setTopScore(-1);
		
		res.setTopMemberName(postProblemReq.getMemberName());
		
		return res;
	}
	
	@PostMapping("/setProblem")
	public void createProblem(@RequestBody PostCreateReq postCreateReq){
		problemService.createProblem(postCreateReq.getMemberName(), postCreateReq.getLanguage(),
				postCreateReq.getContent(), postCreateReq.getTier(), postCreateReq.getIsTutorial());
	}

}
