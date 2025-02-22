package kr.co.metlife.pseudomgtsystemapi.controller;

import kr.co.metlife.pseudomgtsystemapi.store.entity.ConfigTable;
import kr.co.metlife.pseudomgtsystemapi.store.entity.Project;
import kr.co.metlife.pseudomgtsystemapi.store.entity.Table;
import kr.co.metlife.pseudomgtsystemapi.store.entity.User;
import kr.co.metlife.pseudomgtsystemapi.store.repository.*;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SampleController {

    private final UserRepository userRepository;
    private final RuleRepository ruleRepository;
    private final ProjectRepository projectRepository;
    private final ConfigTableRepository configTableRepository;

    @GetMapping("/greet")
    public String greet() {
        return "Hello World!";
    }

    // http "http://localhost:8080/api/users"
    @GetMapping("/users")
    public ResponseEntity<JSONObject> getUsers() {

        JSONObject response = new JSONObject();

        response.put("users", userRepository.findAll());

        return ResponseEntity.ok(response);
    }

    // http "http://localhost:8080/api/project?name=Project-1"
    @GetMapping("/project")
    public ResponseEntity<JSONObject> getProject(@RequestParam String name) {

        JSONObject response = new JSONObject();

        Project foundProject = projectRepository.findByName(name);
        if (foundProject != null) {
            response.put("project", foundProject.getName());
            response.put("projectId", foundProject.getId());
            response.put("tables", foundProject.getConfigTables());
        } else {
            response.put("error", "Project not found");
        }

        return ResponseEntity.ok(response);
    }

    // http "http://localhost:8080/api/table?name=NRS&project=Project-1"
    @GetMapping("/table")
    public ResponseEntity<JSONObject> getProjectTable(@RequestParam String name,
                                                      @RequestParam String project) {

        JSONObject response = new JSONObject();

        ConfigTable foundTable = configTableRepository.findByProjectNameAndName(project, name);
        if (foundTable != null) {
            response.put("projectId", foundTable.getProject().getId());
            response.put("projectId", foundTable.getProject().getName());
            response.put("tableId", foundTable.getId());
            response.put("tableName", foundTable.getName());
            response.put("tableColumns", foundTable.getConfigColumns());
        } else {
            response.put("error", "Table not found");
        }

        return ResponseEntity.ok(response);
    }
}
