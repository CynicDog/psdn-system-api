package kr.co.metlife.pseudomgtsystemapi.flow;

import kr.co.metlife.pseudomgtsystemapi.dto.ParameterDTO;

import java.util.List;

public interface ParameterFlowService {

    List<ParameterDTO> getParameters();
}
