package kr.co.metlife.pseudomgtsystemapi.flow;

import kr.co.metlife.pseudomgtsystemapi.dto.ConfigTableDTO;
import kr.co.metlife.pseudomgtsystemapi.dto.ProjectDTO;

import java.util.List;

public interface ProjectFlowService {

    List<ProjectDTO> getProjectsByUsername(String username);

    ProjectDTO saveProject(ProjectDTO projectDTO);

    ConfigTableDTO saveProjectConfigTable(ConfigTableDTO configTableDTO);
}
