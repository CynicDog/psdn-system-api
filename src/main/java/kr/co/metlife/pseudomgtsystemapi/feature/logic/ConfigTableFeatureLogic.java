package kr.co.metlife.pseudomgtsystemapi.feature.logic;

import kr.co.metlife.pseudomgtsystemapi.feature.ConfigTableFeatureService;
import kr.co.metlife.pseudomgtsystemapi.store.entity.ConfigTable;
import kr.co.metlife.pseudomgtsystemapi.store.repository.ConfigTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ConfigTableFeatureLogic implements ConfigTableFeatureService {

    private final ConfigTableRepository configTableRepository;

    @Override
    public List<ConfigTable> getConfigTableByProjectId(String projectId) {
        return configTableRepository.findAllByProjectId(projectId);
    }

    @Override
    public ConfigTable saveConfigTable(ConfigTable configTable) {
        return configTableRepository.save(configTable);
    }

    @Override
    public Optional<ConfigTable> findConfigTableById(String configTableId) {
        return configTableRepository.findById(configTableId);
    }
}
