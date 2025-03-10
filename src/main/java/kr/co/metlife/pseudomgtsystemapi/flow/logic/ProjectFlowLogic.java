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
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectFlowLogic implements ProjectFlowService {

    private final ProjectFeatureService projectFeatureService;
    private final ConfigTableFeatureService configTableFeatureService;

    @Override
    public List<ProjectDTO> getProjectsByUsername(String username) {
        var projects = projectFeatureService.getProjectsByUsername(username);

        return projects.stream()
                .map(project -> {
                    List<ConfigTable> configTables = configTableFeatureService.getConfigTablesByProjectId(project.getId());
                    return ProjectDTO.builder()
                            .id(project.getId())
                            .username(project.getUsername())
                            .name(project.getName())
                            .sequence(project.getSequence())
                            .status(project.getStatus())
                            .explanation(project.getExplanation())
                            .createTimestamp(project.getCreateTimestamp())
                            .approveTimestamp(project.getApproveTimestamp())
                            .startTimestamp(project.getStartTimestamp())
                            .finishTimestamp(project.getFinishTimestamp())
                            .configTables(configTables)
                            .build();
                })
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDTO saveProject(ProjectDTO projectDTO) {
        Project project = projectDTO.getId() != null
                ? projectFeatureService.findProjectById(projectDTO.getId()).orElse(null)
                : null;

        if (project == null) {
            // Creating a new project using builder
            project = Project.builder()
                    .username(projectDTO.getUsername())
                    .name(projectDTO.getName())
                    .explanation(projectDTO.getExplanation())
                    .sequence(projectDTO.getSequence())
                    .status(projectDTO.getStatus())
                    .startTimestamp(projectDTO.getStartTimestamp())
                    .inputUsername("TODO: JohnDoe")
                    .build();
        } else {
            // Updating an existing project using builder (preserving existing values)
            project = Project.builder()
                    .id(project.getId())
                    .username(projectDTO.getUsername() != null ? projectDTO.getUsername() : project.getUsername())
                    .name(projectDTO.getName() != null ? projectDTO.getName() : project.getName())
                    .explanation(projectDTO.getExplanation() != null ? projectDTO.getExplanation() : project.getExplanation())
                    .sequence(projectDTO.getSequence() != null ? projectDTO.getSequence() : project.getSequence())
                    .status(projectDTO.getStatus() != null ? projectDTO.getStatus() : project.getStatus())
                    .startTimestamp(projectDTO.getStartTimestamp() != null ? projectDTO.getStartTimestamp() : project.getStartTimestamp())
                    .inputUsername(project.getInputUsername())
                    .updateUsername("TODO: JohnDoe")
                    .build();
        }

        // Save project
        Project savedProject = projectFeatureService.saveProject(project);

        // Return DTO using builder
        return ProjectDTO.builder()
                .id(savedProject.getId())
                .username(savedProject.getUsername())
                .name(savedProject.getName())
                .sequence(savedProject.getSequence())
                .status(savedProject.getStatus())
                .explanation(savedProject.getExplanation())
                .createTimestamp(savedProject.getCreateTimestamp())
                .approveTimestamp(savedProject.getApproveTimestamp())
                .startTimestamp(savedProject.getStartTimestamp())
                .finishTimestamp(savedProject.getFinishTimestamp())
                .configTables(List.of())
                .build();
    }

    @Override
    public List<ProjectDTO> saveAllProjects(List<ProjectDTO> projectDTOList) {
        return projectDTOList.stream()
                .map(this::saveProject)
                .collect(Collectors.toList());
    }

    @Override
    public ConfigTableDTO saveProjectConfigTable(String projectId, ConfigTableDTO configTableDTO) {
        ConfigTable configTable = configTableDTO.getId() != null
                ? configTableFeatureService.findConfigTableById(configTableDTO.getId()).orElse(null)
                : null;

        if (configTable == null) {
            // Create a new ConfigTable using builder
            configTable = ConfigTable.builder()
                    .projectId(configTableDTO.getProjectId())
                    .tableId(configTableDTO.getTableId())
                    .name(configTableDTO.getName())
                    .logicalName(configTableDTO.getLogicalName())
                    .explanation(configTableDTO.getExplanation())
                    .iteration(configTableDTO.getIteration())
                    .sequence(configTableDTO.getSequence())
                    .inputUsername("TODO: JohnDoe")
                    .build();
        } else {
            // Update an existing ConfigTable using builder (preserving existing values)
            configTable = ConfigTable.builder()
                    .id(configTable.getId())
                    .projectId(configTableDTO.getProjectId() != null ? configTableDTO.getProjectId() : configTable.getProjectId())
                    .tableId(configTableDTO.getTableId() != null ? configTableDTO.getTableId() : configTable.getTableId())
                    .name(configTableDTO.getName() != null ? configTableDTO.getName() : configTable.getName())
                    .logicalName(configTableDTO.getLogicalName() != null ? configTableDTO.getLogicalName() : configTable.getLogicalName())
                    .explanation(configTableDTO.getExplanation() != null ? configTableDTO.getExplanation() : configTable.getExplanation())
                    .iteration(configTableDTO.getIteration() != null ? configTableDTO.getIteration() : configTable.getIteration())
                    .sequence(configTableDTO.getSequence() != null ? configTableDTO.getSequence() : configTable.getSequence())
                    .inputUsername(configTable.getInputUsername())
                    .updateUsername("TODO: JohnDoe")
                    .build();
        }

        // Save the updated or newly created ConfigTable
        ConfigTable savedConfigTable = configTableFeatureService.saveConfigTable(configTable);

        // Return DTO using builder
        return ConfigTableDTO.builder()
                .id(savedConfigTable.getId())
                .projectId(savedConfigTable.getProjectId())
                .tableId(savedConfigTable.getTableId())
                .name(savedConfigTable.getName())
                .logicalName(savedConfigTable.getLogicalName())
                .explanation(savedConfigTable.getExplanation())
                .iteration(savedConfigTable.getIteration())
                .sequence(savedConfigTable.getSequence())
                .build();
    }

    @Override
    public void deleteProjectConfigTable(String projectId, String configTableId) {
        configTableFeatureService.deleteConfigTable(configTableId);
    }

    @Override
    public void deleteProject(String projectId) {

        List<ConfigTable> configTables = configTableFeatureService.getConfigTablesByProjectId(projectId);
        configTables.forEach(configTable -> {
            configTableFeatureService.deleteConfigTable(configTable.getId());
        });

        projectFeatureService.deleteProject(projectId);
    }
}
