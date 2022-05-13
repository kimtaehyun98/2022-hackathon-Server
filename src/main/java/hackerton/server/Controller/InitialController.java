package hackerton.server.Controller;

import hackerton.server.Model.Member;
import hackerton.server.Repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
@RequiredArgsConstructor
public class InitialController {

    private final TestRepository testRepository;

    @GetMapping("/")
    public void init(Model model) {
        Member member = new Member();
        member.setMemberName("suhwan");
        member.setMemberPw("123");
        member.setMemberTotalScore(100L);


    }
}
