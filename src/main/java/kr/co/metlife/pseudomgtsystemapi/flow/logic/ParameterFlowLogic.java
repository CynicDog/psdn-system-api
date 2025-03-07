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
                .map(parameter -> new ParameterDTO(
                        parameter.getId(),
                        parameter.getAttributeName(),
                        parameter.getNameKorean(),
                        parameter.getNameEnglish(),
                        parameter.getType(),
                        parameter.getDefaultValue(),
                        parameter.getExplanation(),
                        parameter.getInputUsername(),
                        parameter.getInputTimestamp(),
                        parameter.getUpdateUsername(),
                        parameter.getUpdateTimestamp()
                ))
                .collect(Collectors.toList());
    }
}
