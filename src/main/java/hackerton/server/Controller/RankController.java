package hackerton.server.Controller;

import hackerton.server.Model.RankProblem;
import hackerton.server.Model.RankUser;
import hackerton.server.Repository.RankProblemRepository;
import hackerton.server.Repository.RankUserRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/rank")
public class RankController {

    private static final RankProblemRepository rankProblemRepository = new RankProblemRepository();
    private static final RankUserRepository rankUserRepository = new RankUserRepository();

    @GetMapping("/problem")
    public List<RankProblem> rankProblems(Model model) throws SQLException {
        return rankProblemRepository.getAllRankProblem();
    }

    @GetMapping("/user")
    public List<RankUser> rankUsers(Model model) throws SQLException{
        return rankUserRepository.getAllRankUser();
    }
}
