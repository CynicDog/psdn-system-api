package kr.co.metlife.pseudomgtsystemapi.flow.logic;

import kr.co.metlife.pseudomgtsystemapi.feature.ProjectFeatureService;
import kr.co.metlife.pseudomgtsystemapi.flow.ProjectFlowService;
import kr.co.metlife.pseudomgtsystemapi.store.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectFlowLogic implements ProjectFlowService {
    private final ProjectFeatureService service;

    public ProjectFlowLogic(ProjectFeatureService service) {
        this.service = service;
    }

//    public List<Project> retrieveProjectListByUserId(String userId)
//    {
//        return  service.retrieveProjectsByUserId(userId);
//    }
}
