package kr.co.metlife.pseudomgtsystemapi.controller;

import org.json.JSONObject;
import kr.co.metlife.pseudomgtsystemapi.flow.ProjectFlowService;
import kr.co.metlife.pseudomgtsystemapi.store.entity.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectFlowService service;

    public ProjectController(ProjectFlowService service) {
        this.service = service;
    }

    @PostMapping("/byUserId")
    public ResponseEntity<List<Project>> retriveProjectByUserId(@RequestBody String userId)
    {
        JSONObject jObject = new JSONObject(userId);
        List<Project> projects = service.retrieveProjectListByUserId(jObject.getString("userId"));
        return ResponseEntity.ok(projects);
    }
}
