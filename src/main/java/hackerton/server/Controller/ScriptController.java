package hackerton.server.Controller;

import hackerton.server.Model.Script;
import hackerton.server.Repository.ProblemRepository;
import hackerton.server.Repository.ScriptRepository;
import hackerton.server.Service.ProblemService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/scripts")
@Slf4j
public class ScriptController {

    private final ScriptRepository scriptRepository;

    @Autowired
    public ScriptController(ScriptRepository scriptRepository) {
        this.scriptRepository = scriptRepository;
    }

    @GetMapping("/tutorial")
    public List<Script> tutorial(@RequestBody String language) throws SQLException {
        return scriptRepository.getTutorials(language);
    }

    @GetMapping("/user")
    public List<Script> user(@RequestBody String language) throws SQLException {

        return scriptRepository.getUsers(language);
    }

}
