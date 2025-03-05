package kr.co.metlife.pseudomgtsystemapi.controller;

import kr.co.metlife.pseudomgtsystemapi.feature.ProjectFeatureService;
import kr.co.metlife.pseudomgtsystemapi.store.entity.Parameter;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import kr.co.metlife.pseudomgtsystemapi.flow.ProjectFlowService;
import kr.co.metlife.pseudomgtsystemapi.store.entity.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectFeatureService projectFeatureService;

    /**
     * @description 가명화 규칙 파라미터를 조회합니다.
     * @example http :8999/v1/tenants/KOREA/KUDP/system/project/users/JohnDoe
     */
    @GetMapping("/users/{username}")
    ResponseEntity<List<Project>> getProjectsByUsername(@PathVariable String username) {
        return ResponseEntity.ok(projectFeatureService.retrieveProjectsByUsername(username));
    }
}
