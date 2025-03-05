package kr.co.metlife.pseudomgtsystemapi.feature;

import kr.co.metlife.pseudomgtsystemapi.store.entity.Parameter;

import java.util.List;

public interface ParameterFeatureService {
    List<Parameter> getParameters();
}
