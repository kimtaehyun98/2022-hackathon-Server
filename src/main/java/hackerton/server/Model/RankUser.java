package hackerton.server.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class RankUser {

    private String memberName;

    private Long memberTotalScore;
}
