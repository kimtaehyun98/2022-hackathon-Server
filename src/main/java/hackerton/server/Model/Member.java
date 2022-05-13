package hackerton.server.Model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Member {

    private Long memberId;

    private String memberName;

    private String memberPw;


    private Long memberTotalScore;

}
