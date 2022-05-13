package hackerton.server.Controller;

import hackerton.server.Model.PostMember;
import hackerton.server.Repository.MemberRepository;
import hackerton.server.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/create")
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberRepository memberRepository, MemberService memberService) {
        this.memberRepository = memberRepository;
        this.memberService = memberService;
    }

    @PostMapping("/account")
    public void createMember(@RequestBody PostMember postMember){
        memberService.createMember(postMember.getMemberId(), postMember.getMemberName(), postMember.getMemberEmail());
    }
}