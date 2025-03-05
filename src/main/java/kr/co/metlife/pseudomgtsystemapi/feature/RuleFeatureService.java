package kr.co.metlife.pseudomgtsystemapi.feature;

import kr.co.metlife.pseudomgtsystemapi.store.entity.Rule;

import java.util.List;

public interface RuleFeatureService {
    List<Rule> getRules();
}
