package hackerton.server.Controller;

import hackerton.server.Model.PostMember;
import hackerton.server.Repository.MemberRepository;
import hackerton.server.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/create")
@CrossOrigin(origins = "http://localhost:3000, http://homespeak.s3-website.ap-northeast-2.amazonaws.com/#/")
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
        memberService.createMember(postMember.getMemberName(), postMember.getMemberEmail());
    }
}
