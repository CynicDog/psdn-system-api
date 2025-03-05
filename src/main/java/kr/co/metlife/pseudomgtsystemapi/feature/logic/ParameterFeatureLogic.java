package kr.co.metlife.pseudomgtsystemapi.feature.logic;

import kr.co.metlife.pseudomgtsystemapi.feature.ParameterFeatureService;
import kr.co.metlife.pseudomgtsystemapi.store.entity.Parameter;
import kr.co.metlife.pseudomgtsystemapi.store.repository.ParameterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ParameterFeatureLogic implements ParameterFeatureService {

    private final ParameterRepository parameterRepository;

    @Override
    public List<Parameter> getParameters() {
        return parameterRepository.findAll();
    }
}
