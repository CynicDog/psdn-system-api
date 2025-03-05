package kr.co.metlife.pseudomgtsystemapi.flow.logic;

import kr.co.metlife.pseudomgtsystemapi.dto.ProjectDTO;
import kr.co.metlife.pseudomgtsystemapi.feature.ConfigTableFeatureService;
import kr.co.metlife.pseudomgtsystemapi.feature.ProjectFeatureService;
import kr.co.metlife.pseudomgtsystemapi.flow.ProjectFlowService;
import kr.co.metlife.pseudomgtsystemapi.store.entity.ConfigTable;
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
        return projects.stream().map(project -> {

            List<ConfigTable> configTables = configTableFeatureService.getConfigTableByProjectId(project.getId());

            ProjectDTO projectDTO = new ProjectDTO(
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

            return projectDTO;
        }).collect(Collectors.toList());
    }
}
