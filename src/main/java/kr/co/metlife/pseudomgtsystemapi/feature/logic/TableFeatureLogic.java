package kr.co.metlife.pseudomgtsystemapi.feature.logic;

import kr.co.metlife.pseudomgtsystemapi.feature.TableFeatureService;
import kr.co.metlife.pseudomgtsystemapi.store.entity.Table;
import kr.co.metlife.pseudomgtsystemapi.store.repository.TableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TableFeatureLogic implements TableFeatureService {

    private final TableRepository tableRepository;

    @Override
    public List<Table> getTables() {
        return tableRepository.findAll();
    }
}
