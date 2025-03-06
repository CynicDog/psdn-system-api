package kr.co.metlife.pseudomgtsystemapi.flow.logic;

import kr.co.metlife.pseudomgtsystemapi.dto.RuleDTO;
import kr.co.metlife.pseudomgtsystemapi.feature.RuleFeatureService;
import kr.co.metlife.pseudomgtsystemapi.flow.RuleFlowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RuleFlowLogic implements RuleFlowService {

    private final RuleFeatureService ruleFeatureService;

    @Override
    public List<RuleDTO> getRules() {
        return ruleFeatureService
                .getRules()
                .stream()
                .map(rule -> new RuleDTO(
                        rule.getId(),
                        rule.getAttributeName(),
                        rule.getNameKorean(),
                        rule.getNameEnglish(),
                        rule.getSequence(),
                        rule.getExplanation(),
                        rule.getInputUserId(),
                        rule.getInputTimestamp(),
                        rule.getUpdateUserId(),
                        rule.getUpdateTimestamp()
                ))
                .collect(Collectors.toList());
    }
}
