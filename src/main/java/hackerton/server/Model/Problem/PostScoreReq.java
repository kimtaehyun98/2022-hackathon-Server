package hackerton.server.Model.Problem;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostScoreReq {
	
	public int problemId;
	
	public int memberId;
	
	public String memberName;
	
	public int score;
}
