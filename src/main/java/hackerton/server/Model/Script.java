package hackerton.server.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Script {

    int problemId;

    String madeUserName;

    String language;

    String content;

    String tier;

    int topScore;

    String topMemberName;

    int likes;

}
