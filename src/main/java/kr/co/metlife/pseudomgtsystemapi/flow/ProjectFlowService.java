package kr.co.metlife.pseudomgtsystemapi.flow;

import kr.co.metlife.pseudomgtsystemapi.dto.ConfigTableDTO;
import kr.co.metlife.pseudomgtsystemapi.dto.ProjectDTO;

import java.util.List;

public interface ProjectFlowService {

    List<ProjectDTO> getAllProjects();

    List<ProjectDTO> getProjectsByUsername(String username);

    ProjectDTO saveProject(ProjectDTO projectDTO);

    List<ProjectDTO> saveAllProjects(List<ProjectDTO> projectDTOList);

    ConfigTableDTO saveProjectConfigTable(String projectId, ConfigTableDTO configTableDTO);

    void deleteProjectConfigTable(String projectId, String configTableId);

    void deleteProject(String projectId);
}
