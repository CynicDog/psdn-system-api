package kr.co.metlife.pseudomgtsystemapi.store.aggregate.logic;

import kr.co.metlife.pseudomgtsystemapi.store.aggregate.ParameterAggrService;
import kr.co.metlife.pseudomgtsystemapi.store.entity.Parameter;
import kr.co.metlife.pseudomgtsystemapi.store.repository.ParameterRepository;
import org.springframework.stereotype.Service;

@Service
public class ParameterAggrLogic implements ParameterAggrService {
    private final ParameterRepository repository;

    public ParameterAggrLogic(ParameterRepository repository) {
        this.repository = repository;
    }

    @Override
    public Parameter retrieve(String attributeName)
    {
        return  repository.findByAttributeName(attributeName);
    }
}
