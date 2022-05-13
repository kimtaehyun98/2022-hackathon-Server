package hackerton.server.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {

    private Long memberId;

    private String memberName;

    private String memberPw;


    private Long memberTotalScore;

}
