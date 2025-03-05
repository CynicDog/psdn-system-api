package kr.co.metlife.pseudomgtsystemapi.feature;

import kr.co.metlife.pseudomgtsystemapi.store.entity.Project;

import java.util.List;

public interface ProjectFeatureService {
    List<Project> retrieveProjectsByUsername(String username);
}
