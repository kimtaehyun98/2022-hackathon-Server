package hackerton.server.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Member {

    private Long memberId;

    private String memberName;

    private String memberPw;


    private Long memberTotalScore;

}
