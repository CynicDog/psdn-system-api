package kr.co.metlife.pseudomgtsystemapi.store.aggregate.logic;

import kr.co.metlife.pseudomgtsystemapi.dto.ConfigTableDTO;
import kr.co.metlife.pseudomgtsystemapi.store.aggregate.ConfigTableAggrService;
import kr.co.metlife.pseudomgtsystemapi.store.entity.ConfigTable;
import kr.co.metlife.pseudomgtsystemapi.store.repository.ConfigTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfigTableAggrLogic implements ConfigTableAggrService {

    private final ConfigTableRepository repository;


    @Override
    public List<ConfigTable> retrieve(String projectId)
    {
        return  repository.findAllByProjectId(projectId);
    }

    @Override
    public ConfigTable save(ConfigTableDTO dto)
    {
        ConfigTable configTable = ConfigTable.builder()
                .projectId(dto.getProjectId())
                .tableId(dto.getTableId())
                .iteration(dto.getIteration())
                .name(dto.getName())
                .logicalName(dto.getLogicalName())
                .sequence(dto.getSequence())
                .inputUserId(dto.getInputUserId())
                .inputTimestamp(LocalDateTime.now())
                .updateUserId(dto.getUpdateUserId())
                .updateTimestamp(LocalDateTime.now())
                .build();

        return  repository.save(configTable);
    }
}
