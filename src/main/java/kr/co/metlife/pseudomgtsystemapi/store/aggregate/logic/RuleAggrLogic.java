package kr.co.metlife.pseudomgtsystemapi.store.aggregate.logic;

import kr.co.metlife.pseudomgtsystemapi.store.aggregate.RuleAggrService;
import kr.co.metlife.pseudomgtsystemapi.store.entity.Rule;
import kr.co.metlife.pseudomgtsystemapi.store.repository.RuleRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleAggrLogic implements RuleAggrService {
    private final RuleRepository repository;

    public RuleAggrLogic(RuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Rule> retrieve()
    {
        return  repository.findAll(Sort.by(Sort.Direction.ASC, "sequece"));
    }
}
