package hackerton.server.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
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
