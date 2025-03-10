package kr.co.metlife.pseudomgtsystemapi.feature;

import kr.co.metlife.pseudomgtsystemapi.store.entity.ConfigTable;

import java.util.List;
import java.util.Optional;

public interface ConfigTableFeatureService {

    List<ConfigTable> getConfigTablesByProjectId(String projectId);

    ConfigTable saveConfigTable(ConfigTable configTable);

    Optional<ConfigTable> findConfigTableById(String configTableId);

    void deleteConfigTable(String configTableId);
}
