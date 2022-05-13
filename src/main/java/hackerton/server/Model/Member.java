package hackerton.server.Model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    private Long memberId;

    @NotNull
    private String memberName;

    @NotNull
    private String memberPw;


    private Long memberTotalScore;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    private List<UserProblem> UserProblems = new ArrayList<>();

}
