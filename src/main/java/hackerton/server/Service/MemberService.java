package hackerton.server.Service;

import hackerton.server.Model.GetMember;
import hackerton.server.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void createMember(String memberName, String memberEmail){
        memberRepository.createMember(memberName, memberEmail);
    }

    public List<GetMember> getMember(String memberName){
        return memberRepository.getMember(memberName);
    }
}
