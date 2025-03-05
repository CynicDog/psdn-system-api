package kr.co.metlife.pseudomgtsystemapi.feature.logic;

import kr.co.metlife.pseudomgtsystemapi.feature.ProjectFeatureService;
import kr.co.metlife.pseudomgtsystemapi.store.aggregate.ProjectAggrService;
import kr.co.metlife.pseudomgtsystemapi.store.entity.Project;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectFeatureLogic implements ProjectFeatureService {
    private final ProjectAggrService service;

    public ProjectFeatureLogic(ProjectAggrService service) {
        this.service = service;
    }

    public List<Project> retrieveProjectListByUserId(String userId)
    {
        return service.retrieve(userId);
    }
}
