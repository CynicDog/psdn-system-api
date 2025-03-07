package kr.co.metlife.pseudomgtsystemapi.controller;

import kr.co.metlife.pseudomgtsystemapi.dto.ParameterDTO;
import kr.co.metlife.pseudomgtsystemapi.dto.RuleDTO;
import kr.co.metlife.pseudomgtsystemapi.flow.ParameterFlowService;
import kr.co.metlife.pseudomgtsystemapi.flow.RuleFlowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/meta")
@RequiredArgsConstructor
public class MetaController {

    private final RuleFlowService ruleFlowService;
    private final ParameterFlowService parameterFlowService;

    /**
     * @description 가명화 규칙을 조회합니다.
     * @example http GET :8999/v1/tenants/KOREA/KUDP/system/meta/rules
     */
    @GetMapping("/rules")
    ResponseEntity<List<RuleDTO>> getRules() {
        return ResponseEntity.ok(ruleFlowService.getRules());
    }

    /**
     * @description 가명화 규칙 파라미터를 조회합니다.
     * @example http GET :8999/v1/tenants/KOREA/KUDP/system/meta/parameters
     */
    @GetMapping("/parameters")
    ResponseEntity<List<ParameterDTO>> getParameters() {
        return ResponseEntity.ok(parameterFlowService.getParameters());
    }
}
