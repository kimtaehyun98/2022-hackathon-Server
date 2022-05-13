package hackerton.server.Model.Problems;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostCreateReq {
	
	public String MemberName;
	
	public String language;
	
	public String content;
	
	public String tier;
}
