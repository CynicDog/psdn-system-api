package kr.co.metlife.pseudomgtsystemapi.flow.logic;

import kr.co.metlife.pseudomgtsystemapi.dto.ParameterDTO;
import kr.co.metlife.pseudomgtsystemapi.feature.ParameterFeatureService;
import kr.co.metlife.pseudomgtsystemapi.flow.ParameterFlowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ParameterFlowLogic implements ParameterFlowService {

    private final ParameterFeatureService parameterFeatureService;

    @Override
    public List<ParameterDTO> getParameters() {
        return parameterFeatureService
                .getParameters()
                .stream()
                .map(parameter -> ParameterDTO.builder()
                        .id(parameter.getId())
                        .attributeName(parameter.getAttributeName())
                        .nameKorean(parameter.getNameKorean())
                        .nameEnglish(parameter.getNameEnglish())
                        .type(parameter.getType())
                        .defaultValue(parameter.getDefaultValue())
                        .explanation(parameter.getExplanation())
                        .inputUsername(parameter.getInputUsername())
                        .inputTimestamp(parameter.getInputTimestamp())
                        .updateUsername(parameter.getUpdateUsername())
                        .updateTimestamp(parameter.getUpdateTimestamp())
                        .build()
                )
                .collect(Collectors.toList());
    }
}
