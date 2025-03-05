package kr.co.metlife.pseudomgtsystemapi.controller;

import kr.co.metlife.pseudomgtsystemapi.feature.logic.ParameterFeatureLogic;
import kr.co.metlife.pseudomgtsystemapi.feature.logic.RuleFeatureLogic;
import kr.co.metlife.pseudomgtsystemapi.store.entity.Rule;
import kr.co.metlife.pseudomgtsystemapi.store.repository.RuleRepository;
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

    private final RuleFeatureLogic ruleFeatureLogic;
    private final ParameterFeatureLogic parameterFeatureLogic;

    /**
     * @description 가명화 규칙을 조회합니다.
     * @example http :8999/v1/tenants/KOREA/KUDP/system/meta/rules
     */
    @GetMapping("/rules")
    ResponseEntity<List<Rule>> getRules() {
        return ResponseEntity.ok(ruleFeatureLogic.getRules());
    }

    /**
     * @description 가명화 규칙 파라미터를 조회합니다.
     * @example http :8999/v1/tenants/KOREA/KUDP/channel/meta/parameters
     */
    @GetMapping("/parameters")
    ResponseEntity<List<Rule>> getParameters() {
        return ResponseEntity.ok(ruleFeatureLogic.getRules());
    }
}
