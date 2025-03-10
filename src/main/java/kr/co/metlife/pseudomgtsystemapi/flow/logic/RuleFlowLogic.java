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
                .map(rule -> RuleDTO.builder()
                        .id(rule.getId())
                        .attributeName(rule.getAttributeName())
                        .nameKorean(rule.getNameKorean())
                        .nameEnglish(rule.getNameEnglish())
                        .sequence(rule.getSequence())
                        .explanation(rule.getExplanation())
                        .inputUsername(rule.getInputUsername())
                        .inputTimestamp(rule.getInputTimestamp())
                        .updateUsername(rule.getUpdateUsername())
                        .updateTimestamp(rule.getUpdateTimestamp())
                        .build()
                )
                .collect(Collectors.toList());
    }
}
