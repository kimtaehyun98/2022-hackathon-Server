package hackerton.server.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetMember {
    private String memberName;

    private String memberEmail;

    private int memberTotalScore;

    private int memberSolveCnt;
}
