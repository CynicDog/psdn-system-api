package kr.co.metlife.pseudomgtsystemapi.controller;

import kr.co.metlife.pseudomgtsystemapi.store.entity.Rule;
import kr.co.metlife.pseudomgtsystemapi.store.repository.RuleRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DemoController {

    private final RuleRepository ruleRepository;

    @GetMapping("/greet")
    public String greet() {
        return "Hello World!";
    }

//    @GetMapping("/PSDN-Master")
//    public JSONObject rules() {
//        JSONObject response = new JSONObject();
//        JSONArray ruleArray = new JSONArray();
//        JSONArray parameterArray = new JSONArray();
//
//        // Fetch all rules along with their parameters
//        List<Rule> rules = ruleRepository.findAll();
//        for (Rule rule : rules) {
//            // Rule JSON
//            JSONObject ruleObj = new JSONObject();
//            ruleObj.put("ID", rule.getUuid().toString());
//            ruleObj.put("NAME_EN", rule.getNameEnglish());
//            ruleObj.put("NAME_KO", rule.getNameKorean());
//            ruleArray.add(ruleObj);
//
//            // Iterate through associated parameters
//            rule.getParameters().forEach(parameter -> {
//                JSONObject paramObj = new JSONObject();
//                paramObj.put("ID", parameter.getUuid().toString());
//                paramObj.put("NAME_EN", parameter.getNameEnglish());
//                paramObj.put("NAME_KO", parameter.getNameKorean());
//                paramObj.put("TYPE", parameter.getType());
//                parameterArray.add(paramObj);
//            });
//        }
//
//        response.put("rules", ruleArray);
//        response.put("parameters", parameterArray);
//
//        return response;
//    }
}
