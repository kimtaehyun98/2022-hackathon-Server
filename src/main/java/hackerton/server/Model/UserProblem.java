package hackerton.server.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
public class UserProblem {

    private Long userProblemId;

    private Long memberId;

    private Long problemId;

    private Long score;

}
