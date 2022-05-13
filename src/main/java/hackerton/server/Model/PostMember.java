package hackerton.server.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostMember {
    private Long memberId;

    private String memberName;

    private String memberEmail;
}
