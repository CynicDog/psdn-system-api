package kr.co.metlife.pseudomgtsystemapi.flow.logic;

import kr.co.metlife.pseudomgtsystemapi.dto.ConfigTableDTO;
import kr.co.metlife.pseudomgtsystemapi.dto.ProjectDTO;
import kr.co.metlife.pseudomgtsystemapi.feature.ConfigTableFeatureService;
import kr.co.metlife.pseudomgtsystemapi.feature.ProjectFeatureService;
import kr.co.metlife.pseudomgtsystemapi.flow.ProjectFlowService;
import kr.co.metlife.pseudomgtsystemapi.store.entity.ConfigTable;
import kr.co.metlife.pseudomgtsystemapi.store.entity.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectFlowLogic implements ProjectFlowService {

    private final ProjectFeatureService projectFeatureService;
    private final ConfigTableFeatureService configTableFeatureService;

    @Override
    public List<ProjectDTO> getProjectsByUsername(String username) {

        var projects = projectFeatureService.getProjectsByUsername(username);
        return projects.stream().map(project -> {

            List<ConfigTable> configTables = configTableFeatureService.getConfigTableByProjectId(project.getId());
            return new ProjectDTO(
                    project.getId(),
                    project.getUsername(),
                    project.getName(),
                    project.getSequence(),
                    project.getStatus(),
                    project.getExplanation(),
                    project.getCreateTimestamp(),
                    project.getApproveTimestamp(),
                    project.getStartTimestamp(),
                    project.getFinishTimestamp(),
                    configTables
            );
        }).collect(Collectors.toList());
    }

    @Override
    public ProjectDTO saveProject(ProjectDTO projectDTO) {
        Project project = projectDTO.getId() != null
                ? projectFeatureService.findProjectById(projectDTO.getId()).orElse(null)
                : null;

        if (project == null) {
            // Create a new Project if it doesn't exist
            project = new Project();
            project.setUsername(projectDTO.getUsername());
            project.setName(projectDTO.getName());
            project.setExplanation( projectDTO.getExplanation());
            project.setSequence(projectDTO.getSequence());
            project.setStatus(projectDTO.getStatus());
            project.setStartTimestamp(projectDTO.getStartTimestamp());
            project.setInputUsername("TODO: JohnDoe");

        } else {
            // Update existing Project
            project.setUsername(projectDTO.getUsername() != null ? projectDTO.getUsername() : project.getUsername());
            project.setName(projectDTO.getName() != null ? projectDTO.getName() : project.getName());
            project.setExplanation(projectDTO.getExplanation() != null ? projectDTO.getExplanation() : project.getExplanation());
            project.setSequence(projectDTO.getSequence() != null ? projectDTO.getSequence() : project.getSequence());
            project.setStatus(projectDTO.getStatus() != null ? projectDTO.getStatus() : project.getStatus());
            project.setStartTimestamp(projectDTO.getStartTimestamp() != null ? projectDTO.getStartTimestamp() : project.getStartTimestamp());
            project.setUpdateUsername("TODO: JohnDoe");
        }

        // Save the updated or newly created Project
        Project savedProject = projectFeatureService.saveProject(project);

        return new ProjectDTO(
                savedProject.getId(),
                savedProject.getUsername(),
                savedProject.getName(),
                savedProject.getSequence(),
                savedProject.getStatus(),
                savedProject.getExplanation(),
                savedProject.getCreateTimestamp(),
                savedProject.getApproveTimestamp(),
                savedProject.getStartTimestamp(),
                savedProject.getFinishTimestamp(),
                List.of()
        );
    }

    @Override
    public ConfigTableDTO saveProjectConfigTable(ConfigTableDTO configTableDTO) {
        ConfigTable configTable = configTableDTO.getId() != null
                ? configTableFeatureService.findConfigTableById(configTableDTO.getId()).orElse(null)
                : null;

        if (configTable == null) {
            // Create a new ConfigTable if it doesn't exist
            configTable = new ConfigTable();
            configTable.setProjectId(configTableDTO.getProjectId());
            configTable.setTableId(configTableDTO.getTableId());
            configTable.setName(configTableDTO.getName());
            configTable.setLogicalName(configTableDTO.getLogicalName());
            configTable.setExplanation(configTableDTO.getExplanation());
            configTable.setIteration(configTableDTO.getIteration());
            configTable.setSequence(configTableDTO.getSequence());
            configTable.setInputUsername("TODO: JohnDoe");
        } else {
            // Update only the non-null properties
            configTable.setProjectId(configTableDTO.getProjectId() != null ? configTableDTO.getProjectId() : configTable.getProjectId());
            configTable.setTableId(configTableDTO.getTableId() != null ? configTableDTO.getTableId() : configTable.getTableId());
            configTable.setName(configTableDTO.getName() != null ? configTableDTO.getName() : configTable.getName());
            configTable.setLogicalName(configTableDTO.getLogicalName() != null ? configTableDTO.getLogicalName() : configTable.getLogicalName());
            configTable.setExplanation(configTableDTO.getExplanation() != null ? configTableDTO.getExplanation() : configTable.getExplanation());
            configTable.setIteration(configTableDTO.getIteration() != null ? configTableDTO.getIteration() : configTable.getIteration());
            configTable.setSequence(configTableDTO.getSequence() != null ? configTableDTO.getSequence() : configTable.getSequence());
            configTable.setUpdateUsername("TODO: JohnDoe");
        }

        // Save the updated or newly created ConfigTable
        ConfigTable savedConfigTable = configTableFeatureService.saveConfigTable(configTable);

        return new ConfigTableDTO(
                savedConfigTable.getId(),
                savedConfigTable.getProjectId(),
                savedConfigTable.getTableId(),
                savedConfigTable.getName(),
                savedConfigTable.getLogicalName(),
                savedConfigTable.getExplanation(),
                savedConfigTable.getIteration(),
                savedConfigTable.getSequence()
        );
    }
}
