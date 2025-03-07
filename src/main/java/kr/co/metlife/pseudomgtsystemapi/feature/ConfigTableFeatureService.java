package kr.co.metlife.pseudomgtsystemapi.feature;

import kr.co.metlife.pseudomgtsystemapi.store.entity.ConfigTable;

import java.util.List;

public interface ConfigTableFeatureService {

    List<ConfigTable> getConfigTableByProjectId(String projectId);

    ConfigTable saveConfigTable(ConfigTable configTable);
}
