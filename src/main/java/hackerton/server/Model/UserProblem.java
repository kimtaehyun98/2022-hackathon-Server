package hackerton.server.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class UserProblem {

    private Long userProblemId;

    private String memberName;

    private Long problemId;

    private Long score;

}
