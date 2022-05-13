package hackerton.server.Model.Problem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class PostScoreRes {
	
	public String topMemberName;
	
	public int topScore;
}
