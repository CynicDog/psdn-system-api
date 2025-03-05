package kr.co.metlife.pseudomgtsystemapi.flow;

import kr.co.metlife.pseudomgtsystemapi.dto.ProjectDTO;

import java.util.List;

public interface ProjectFlowService {
    List<ProjectDTO> getProjectsByUsername(String username);
}
