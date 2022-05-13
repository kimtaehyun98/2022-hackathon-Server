package hackerton.server.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class UserProblem {

    @Id @GeneratedValue
    private Long userProblemId;
//
//    private Long memberId;
//
//    private Long problemId;

    private Long score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problemId")
    private Problem problem;
}
