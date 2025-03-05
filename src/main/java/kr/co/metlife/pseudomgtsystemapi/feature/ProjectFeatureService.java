package kr.co.metlife.pseudomgtsystemapi.feature;

import kr.co.metlife.pseudomgtsystemapi.store.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProjectFeatureService {
    List<Project> retrieveProjectListByUserId(String userId);
}
