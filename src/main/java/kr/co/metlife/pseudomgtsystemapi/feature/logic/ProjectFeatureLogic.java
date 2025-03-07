package kr.co.metlife.pseudomgtsystemapi.feature.logic;

import kr.co.metlife.pseudomgtsystemapi.feature.ProjectFeatureService;
import kr.co.metlife.pseudomgtsystemapi.store.entity.Project;
import kr.co.metlife.pseudomgtsystemapi.store.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProjectFeatureLogic implements ProjectFeatureService {

    private final ProjectRepository projectRepository;

    @Override
    public List<Project> getProjectsByUsername(String username) {
        return projectRepository.findAllByUsername(username);
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }
}
