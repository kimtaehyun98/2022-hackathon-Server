package hackerton.server.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class RankProblem {

    private Long problemId;

    private String topMemberName;

    private Long topScore;
}
