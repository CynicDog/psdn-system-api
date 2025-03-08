package kr.co.metlife.pseudomgtsystemapi.controller;

import kr.co.metlife.pseudomgtsystemapi.dto.ConfigTableDTO;
import kr.co.metlife.pseudomgtsystemapi.dto.ProjectDTO;
import lombok.RequiredArgsConstructor;
import kr.co.metlife.pseudomgtsystemapi.flow.ProjectFlowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectFlowService projectFlowService;

    /**
     * @description 사용자의 프로젝트를 조회합니다.
     * @example http GET :8999/v1/tenants/KOREA/KUDP/system/projects?username=JohnDoe
     */
    @GetMapping
    ResponseEntity<List<ProjectDTO>> getProjectsByUsername(@RequestParam String username) {
        return ResponseEntity.ok(projectFlowService.getProjectsByUsername(username));
    }

    @PostMapping("/save")
    ResponseEntity<ProjectDTO> saveProject(@RequestBody ProjectDTO projectDTO) {
        return ResponseEntity.ok(projectFlowService.saveProject(projectDTO));
    }

    @PostMapping("/{projectId}/configTable/save")
    ResponseEntity<ConfigTableDTO> saveConfigTable(@PathVariable String projectId, @RequestBody ConfigTableDTO configTableDTO) {
        return ResponseEntity.ok(projectFlowService.saveProjectConfigTable(projectId, configTableDTO));
    }

    @DeleteMapping("/{projectId}/configTables/{configTableId}/delete")
    ResponseEntity<Void> deleteConfigTable(@PathVariable String projectId, @PathVariable String configTableId) {
        projectFlowService.deleteProjectConfigTable(projectId, configTableId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{projectId}/delete")
    ResponseEntity<Void> deleteProject(@PathVariable String projectId) {
        projectFlowService.deleteProject(projectId);
        return ResponseEntity.noContent().build();
    }
}
