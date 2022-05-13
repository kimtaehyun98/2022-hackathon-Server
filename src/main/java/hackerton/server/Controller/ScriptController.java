package hackerton.server.Controller;

import hackerton.server.Model.Script;
import hackerton.server.Repository.ScriptRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/scripts")
public class ScriptController {

    private static final ScriptRepository scriptRepository = new ScriptRepository();

    @GetMapping("/tutorial")
    public ArrayList<Script> tutorial(Model model) throws SQLException {
        return scriptRepository.getTutorials();
    }

    @GetMapping("/user")
    public ArrayList<Script> user(Model model) throws SQLException {
        return scriptRepository.getUsers();
    }

}
