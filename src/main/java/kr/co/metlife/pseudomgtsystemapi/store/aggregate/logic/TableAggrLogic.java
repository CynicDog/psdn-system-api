package kr.co.metlife.pseudomgtsystemapi.store.aggregate.logic;

import kr.co.metlife.pseudomgtsystemapi.store.aggregate.TableAggrService;
import kr.co.metlife.pseudomgtsystemapi.store.entity.Table;
import kr.co.metlife.pseudomgtsystemapi.store.repository.TableRepository;
import org.springframework.stereotype.Service;

@Service
public class TableAggrLogic implements TableAggrService {
    private final TableRepository repository;

    public TableAggrLogic(TableRepository repository) {
        this.repository = repository;
    }

    @Override
    public Table retrieve(String name)
    {
        return  repository.findByName(name);
    }
}
