package hackerton.server.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Problem {

    private Long problemId;

    private String madeUserName;

    private String language;

    private String content;

    private String tier;

    private Long likes;

    private Long topScore;

    private String topMemberName;


}
