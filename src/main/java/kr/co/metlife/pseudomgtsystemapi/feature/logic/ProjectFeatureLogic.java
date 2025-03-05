package kr.co.metlife.pseudomgtsystemapi.feature.logic;

import kr.co.metlife.pseudomgtsystemapi.feature.ProjectFeatureService;
import kr.co.metlife.pseudomgtsystemapi.store.aggregate.ProjectAggrService;
import kr.co.metlife.pseudomgtsystemapi.store.entity.Project;
import kr.co.metlife.pseudomgtsystemapi.store.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProjectFeatureLogic implements ProjectFeatureService {

    private final ProjectRepository projectRepository;

    @Override
    public List<Project> retrieveProjectsByUsername(String username) {
        return projectRepository.findAllByUsername(username);
    }
}
