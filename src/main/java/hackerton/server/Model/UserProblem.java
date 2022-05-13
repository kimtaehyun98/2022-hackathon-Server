package hackerton.server.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class UserProblem {

    private Long userProblemId;

    private Long memberId;

    private Long problemId;

    private Long score;

}
