package hackerton.server.Controller;

import hackerton.server.Model.RankProblem;
import hackerton.server.Model.RankUser;
import hackerton.server.Repository.RankProblemRepository;
import hackerton.server.Repository.RankUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/rank")
@CrossOrigin(origins = "http://d3mri5dv71y0ua.cloudfront.net/")
public class RankController {

    private final RankProblemRepository rankProblemRepository;
    private final RankUserRepository rankUserRepository;

    @Autowired
    public RankController(RankProblemRepository rankProblemRepository, RankUserRepository rankUserRepository) {
        this.rankProblemRepository = rankProblemRepository;
        this.rankUserRepository = rankUserRepository;
    }


    @GetMapping("/problem")
    public List<RankProblem> rankProblems(Model model) throws SQLException {
        return rankProblemRepository.getAllRankProblem();
    }

    @GetMapping("/user")
    public List<RankUser> rankUsers(Model model) throws SQLException{
        return rankUserRepository.getAllRankUser();
    }
}
