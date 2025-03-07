package kr.co.metlife.pseudomgtsystemapi.flow.logic;

import kr.co.metlife.pseudomgtsystemapi.dto.TableDTO;
import kr.co.metlife.pseudomgtsystemapi.feature.TableFeatureService;
import kr.co.metlife.pseudomgtsystemapi.flow.TableFlowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TableFlowLogic implements TableFlowService {

    private final TableFeatureService tableFeatureService;

    @Override
    public List<TableDTO> getTables() {
        return tableFeatureService
                .getTables()
                .stream()
                .map(table -> new TableDTO(
                        table.getId(),
                        table.getName(),
                        table.getLogicalName(),
                        table.getInputUsername(),
                        table.getInputTimestamp(),
                        table.getUpdateUsername(),
                        table.getUpdateTimestamp()
                ))
                .collect(Collectors.toList());
    }
}
