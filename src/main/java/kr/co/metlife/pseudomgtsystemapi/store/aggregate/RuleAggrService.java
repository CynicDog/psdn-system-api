package kr.co.metlife.pseudomgtsystemapi.store.aggregate;

import kr.co.metlife.pseudomgtsystemapi.store.entity.Rule;

import java.util.List;

public interface RuleAggrService {
    List<Rule> retrieve();
}
