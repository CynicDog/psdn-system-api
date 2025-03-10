package kr.co.metlife.pseudomgtsystemapi.feature;

import kr.co.metlife.pseudomgtsystemapi.store.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectFeatureService {

    List<Project> getAllProjects();

    List<Project> getProjectsByUsername(String username);

    Project saveProject(Project project);

    Optional<Project> findProjectById(String projectId);

    void deleteProject(String projectId);
}
