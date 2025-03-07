package kr.co.metlife.pseudomgtsystemapi.flow;

import kr.co.metlife.pseudomgtsystemapi.dto.RuleDTO;

import java.util.List;

public interface RuleFlowService {

    List<RuleDTO> getRules();
}
