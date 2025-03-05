package kr.co.metlife.pseudomgtsystemapi.controller;

import kr.co.metlife.pseudomgtsystemapi.dto.ProjectDTO;
import lombok.RequiredArgsConstructor;
import kr.co.metlife.pseudomgtsystemapi.flow.ProjectFlowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectFlowService projectFlowService;

    /**
     * @description 사용자의 프로젝트를 조회합니다.
     * @example http :8999/v1/tenants/KOREA/KUDP/system/project/users/JohnDoe
     */
    @GetMapping("/users/{username}")
    ResponseEntity<List<ProjectDTO>> getProjectsByUsername(@PathVariable String username) {
        return ResponseEntity.ok(projectFlowService.getProjectsByUsername(username));
    }
}
