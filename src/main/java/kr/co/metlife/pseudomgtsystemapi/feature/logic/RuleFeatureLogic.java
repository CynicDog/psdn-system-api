package kr.co.metlife.pseudomgtsystemapi.feature.logic;

import kr.co.metlife.pseudomgtsystemapi.feature.RuleFeatureService;
import kr.co.metlife.pseudomgtsystemapi.store.aggregate.logic.RuleAggrLogic;
import kr.co.metlife.pseudomgtsystemapi.store.entity.Rule;
import kr.co.metlife.pseudomgtsystemapi.store.repository.RuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RuleFeatureLogic implements RuleFeatureService {

    private final RuleRepository ruleRepository;

    @Override
    public List<Rule> getRules() {
        return ruleRepository.findAll();
    }
}
