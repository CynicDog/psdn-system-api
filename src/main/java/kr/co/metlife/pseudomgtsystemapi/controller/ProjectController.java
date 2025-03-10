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
     * @description 전체 또는 사용자별 프로젝트를 조회합니다.
     * @example
     *  http GET :8999/v1/tenants/KOREA/KUDP/system/projects
     *  http GET :8999/v1/tenants/KOREA/KUDP/system/projects?username=JohnDoe
     */
    @GetMapping
    ResponseEntity<List<ProjectDTO>> getProjects(@RequestParam(required = false) String username) {
        if (username != null) {
            return ResponseEntity.ok(projectFlowService.getProjectsByUsername(username));
        }
        return ResponseEntity.ok(projectFlowService.getAllProjects());
    }

    /**
     * @description 사용자의 단일 프로젝트를 저장합니다.
     * @example http POST :8999/v1/tenants/KOREA/KUDP/system/projects/save
     */
    @PostMapping("/save")
    ResponseEntity<ProjectDTO> saveProject(@RequestBody ProjectDTO projectDTO) {
        return ResponseEntity.ok(projectFlowService.saveProject(projectDTO));
    }

    /**
     * @description 사용자의 프로젝트를 저장합니다.
     * @example http POST :8999/v1/tenants/KOREA/KUDP/system/projects/saveAll
     */
    @PostMapping("/saveAll")
    ResponseEntity<List<ProjectDTO>> saveProject(@RequestBody List<ProjectDTO> projectDTOList) {
        return ResponseEntity.ok(projectFlowService.saveAllProjects(projectDTOList));
    }

    /**
     * @description 사용자의 프로젝트 테이블을 저장합니다.
     * @example http POST :8999/v1/tenants/KOREA/KUDP/system/projects/{projectId}/configTable/save
     */
    @PostMapping("/{projectId}/configTable/save")
    ResponseEntity<ConfigTableDTO> saveConfigTable(@PathVariable String projectId, @RequestBody ConfigTableDTO configTableDTO) {
        return ResponseEntity.ok(projectFlowService.saveProjectConfigTable(projectId, configTableDTO));
    }

    /**
     * @description 사용자의 프로젝트 테이블을 삭제합니다.
     * @example http DELETE :8999/v1/tenants/KOREA/KUDP/system/projects/{projectId}/configTables/{configTableId}/delete
     */
    @DeleteMapping("/{projectId}/configTables/{configTableId}/delete")
    ResponseEntity<Void> deleteConfigTable(@PathVariable String projectId, @PathVariable String configTableId) {
        projectFlowService.deleteProjectConfigTable(projectId, configTableId);
        return ResponseEntity.noContent().build();
    }

    /**
     * @description 사용자의 프로젝트를 삭제합니다.
     * @example http DELETE :8999/v1/tenants/KOREA/KUDP/system/projects/{projectId}/delete
     */
    @DeleteMapping("/{projectId}/delete")
    ResponseEntity<Void> deleteProject(@PathVariable String projectId) {
        projectFlowService.deleteProject(projectId);
        return ResponseEntity.noContent().build();
    }
}
