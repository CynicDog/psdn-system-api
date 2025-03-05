package kr.co.metlife.pseudomgtsystemapi.store.util;

import jakarta.transaction.Transactional;
import kr.co.metlife.pseudomgtsystemapi.store.entity.*;
import kr.co.metlife.pseudomgtsystemapi.store.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer implements CommandLineRunner {

    private final RuleRepository ruleRepository;
    private final ParameterRepository parameterRepository;
    private final ProjectRepository projectRepository;
    private final TableRepository tableRepository;
    private final ColumnRepository columnRepository;
    private final ConfigTableRepository configTableRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        initializeRulesAndParameters();
    }

    private void initializeRulesAndParameters() {

        Rule rule9 = new Rule("suppression", "삭제", "Suppression", 1, "원본정보에서 개인정보를 단순 삭제 (칼럼 삭제) ", "MLPNZD_SYS");
        Rule rule5 = new Rule("masking", "마스킹", "Masking", 2, "특정 항목의 일부 또는 전부를 공백 또는 문자(‘ * ’, ‘ _ ’ 등이나 전각 기호)로 대체", "MLPNZD_SYS");
        Rule rule14 = new Rule("outlier_generalization", "특이치 범주화", "Outlier Generalization", 3, "분포상의 특이성으로 인해 식별이 가능한 데이터 건을 일반화를 적용하여 식별성을 낮추는 기법", "MLPNZD_SYS");
        Rule rule10 = new Rule("top_down_coding", "상하단 코딩", "Top Down Coding", 4, "상하위, 상위 또는 하위 등의 검증 유형에 따른 분위수 내 해당하는 데이터를 분위 경계값으로 대체하는 기법", "MLPNZD_SYS");
        Rule rule7 = new Rule("data_range", "범위 방법", "Data Range", 5, "수치 데이터를 임의의 수 기준의 범위(range)로 설정하는 기법으로, 해당 값의 범위 또는 구간(interval)으로 표현", "MLPNZD_SYS");
        Rule rule8 = new Rule("partial_suppression", "부분 삭제", "Partial Suppression", 6, "개인정보 칼럼 전체를 삭제하는 방식이 아니라 레코드 데이터의 일부를 삭제", "MLPNZD_SYS");
        Rule rule4 = new Rule("top_down_nullification", "로컬 무효화", "Local Nullify", 7, "금액, 나이 등 수치형 데이터에서 나타나는 극단값을 가지는 데이터를 감지하여 해당 수치를 무효화(null 처리)하거나, 해당 레코드를 삭제하는 기법", "MLPNZD_SYS");
        Rule rule1 = new Rule("group_aggregation", "그룹 총계", "Group Aggregation", 8, "정보집합물 내 하나 또는 그 이상의 행 항목에 해당하는 특정 열 항목을 총계처리", "MLPNZD_SYS");
        Rule rule12 = new Rule("rounding", "일반 라운딩", "Normal Rounding", 9, "올림, 내림, 반올림 등의 기준을 적용하여 집계 처리하는 방법으로, 일반적으로 세세한 정보보다는 전체 통계정보가 필요한 경우 많이 사용", "MLPNZD_SYS");
        Rule rule3 = new Rule("random_rounding", "랜덤 라운딩", "Random Rounding", 10, "수치 데이터를 임의의 수인 자리 수, 실제 수 기준으로 올림(round up) 또는 내림(round down)하는 기법", "MLPNZD_SYS");
        Rule rule13 = new Rule("noise_addition", "잡음 추가", "Noise Addition", 11, "개인정보에 임의의 숫자 등 잡음을 추가하는 방법 ", "MLPNZD_SYS");
        Rule rule11 = new Rule("permutation", "순열", "Permutation", 12, "개인정보를 다른 행 항목의 정보와 무작위로 순서를 변경하여 전체 정보에 대한 변경 없이 특정 정보가 해당 개인과 연결되지 않도록 하는 방법", "MLPNZD_SYS");
        Rule rule6 = new Rule("mapping", "문자 대체", "Letters Replacement", 13, "식별자에 해당하는 값들을 정해진 사전에 등재된 단어로 대체하여 자세한 개인정보를 숨기는 방법", "MLPNZD_SYS");
        Rule rule2 = new Rule("random_selection_replacement", "단어 사전 무작위 추출", "Random Selection Replacement", 14, "정보집합물 내 하나 또는 그 이상의 행 항목에 해당하는 특정 열 항목을 총계처리", "MLPNZD_SYS");
        ruleRepository.saveAll(List.of(rule1, rule2, rule3, rule4, rule5, rule6, rule7, rule8, rule9, rule10, rule11, rule12, rule13, rule14));

        Parameter param1 = new Parameter("alternative", "검증 유형", "Alternative", "code", "two_side", "검증 유형 - 상하위(two-side), 하위(less), 상위(greater)", "MLPNZD_SYS");
        Parameter param2 = new Parameter("binning_length", "카운트 구간 길이", "Counting Bin Size", "int", "0", "연속형 데이터에 대하여 특이치 임계치를 산정하기 위해 설정되는 카운트 구간 길이", "MLPNZD_SYS");
        Parameter param3 = new Parameter("chaos_level", "무작위 수준", "Chaos Level ", "int", "", "잡음 추가 시 적용되는 무작위 수준", "MLPNZD_SYS");
        Parameter param4 = new Parameter("grouping_columns", "연관 칼럼", "Grouping Column", "string", "", "그루핑 시 사용되는 연관 칼럼", "MLPNZD_SYS");
        Parameter param5 = new Parameter("mapping_definition", "원본 값 - 대체 값 정의", "Mapping Definition", "mapping", "", "원본 데이터를 대체하는 문자", "MLPNZD_SYS");
        Parameter param6 = new Parameter("mask_char", "마스킹 문자", "Masking Character", "string", "", "마스킹 처리에 사용될 문자", "MLPNZD_SYS");
        Parameter param7 = new Parameter("mask_range", "마스킹 범위", "Masking Range", "range", "0", "마스킹 처리 범위", "MLPNZD_SYS");
        Parameter param8 = new Parameter("percentile", "분위수", "Percentile", "int", "5", "규칙 적용에 사용할 분위수 예) 상하위 5% ", "MLPNZD_SYS");
        Parameter param9 = new Parameter("re_identification_yn", "재식별화 키 여부", "Re-Identification YN", "bool", "true", "해당 칼럼의 데이터가 삭제된 후 재식별키에 사용되는지 여부", "MLPNZD_SYS");
        Parameter param10 = new Parameter("record_deletion", "레코드 삭제 여부", "Record Deletion YN", "bool", "false", "로컬 삭제 시 레코드 삭제 여부", "MLPNZD_SYS");
        Parameter param11 = new Parameter("replacement_statistic", "대체 통계값", "Replacement Statistic", "code", "mean", "총계 처리에 사용될 통계값 - 평균값(mean), 중앙값(median), 최빈값(mode)", "MLPNZD_SYS");
        Parameter param12 = new Parameter("rounding_mode", "라운딩 모드", "Rounding Mode ", "code", "nearest", "라운딩 모드 - 올림(up), 내림(down), 반올림(nearest)", "MLPNZD_SYS");
        Parameter param13 = new Parameter("rounding_position", "라운딩 자리수", "Rounding Position", "int", "", "라운딩 자리수", "MLPNZD_SYS");
        Parameter param14 = new Parameter("rounding_size", "데이터 구간 배수", "Binning Size", "int", "3", "범위 방법에 사용될 배수", "MLPNZD_SYS");
        Parameter param15 = new Parameter("scope_specification", "부분 삭제 범위", "Partial Suppression Range", "range", "0", "부분 삭제 범위", "MLPNZD_SYS");
        Parameter param16 = new Parameter("selection_list", "단어 사전", "Replacement Dictionary", "list", "", "단어 사전 무작위 추출에 사용될 사전", "MLPNZD_SYS");
        Parameter param17 = new Parameter("threshold_criterion", "임계 기준", "Threshold Criteria", "code", "count", "특이치 범주화 기법 적용 시 사용되는 임계 기준 - 비율(ratio), 건수(count)", "MLPNZD_SYS");
        Parameter param18 = new Parameter("threshold_value", "임계 값", "Threshold Value ", "float", "1", "특이치 범주화 기법 적용 시 사용되는 임계 값 ", "MLPNZD_SYS");
        parameterRepository.saveAll(List.of(param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12, param13, param14, param15, param16, param17, param18));

        /* Mock Table "LBF" insert */
        Table LBF = new Table("LBF", "LBF", "MLPNZD_SYS");
        tableRepository.save(LBF);
        for (int i = 0; i < 204; i++) {
            String dataType = (i % 2 == 0) ? "NVARCHAR" : "DECIMAL";
            Column column1 = new Column(LBF.getId(), String.format("col-%s", i), String.format("col-logical-%s", i), dataType, "MLPNZD_SYS");
            columnRepository.save(column1);
        }

        /* Mock Table "HLT" insert */
        Table HLT = new Table("HLT", "HLT", "MLPNZD_SYS");
        tableRepository.save(HLT);
        for (int i = 0; i < 401; i++) {
            String dataType = (i % 2 == 0) ? "NVARCHAR" : "DECIMAL";
            Column column1 = new Column(HLT.getId(), String.format("col-%s", i), String.format("col-logical-%s", i), dataType, "MLPNZD_SYS");
            columnRepository.save(column1);
        }

        /* Mock Table "KBW" insert */
        Table KBW = new Table("KBW", "HLT", "MLPNZD_SYS");
        tableRepository.save(KBW);
        for (int i = 0; i < 251; i++) {
            String dataType = (i % 2 == 0) ? "NVARCHAR" : "DECIMAL";
            Column column1 = new Column(KBW.getId(), String.format("col-%s", i), String.format("col-logical-%s", i), dataType, "MLPNZD_SYS");
            columnRepository.save(column1);
        }

        Project project1 = new Project("JohnDoe", "Project - 1", 1, Project.Status.APPROVED.name(), "JohnDoe's First Project.", "MLPNZD_SYS",
                LocalDateTime.of(2025, Month.JANUARY, 20, 0, 0),
                LocalDateTime.of(2025, Month.FEBRUARY, 1, 0, 0),
                null
        );
        Project project2 = new Project("JohnDoe", "Project - 2", 2, Project.Status.PENDING.name(), "JohnDoe's Second Project.", "MLPNZD_SYS",
                null,
                LocalDateTime.of(2025, Month.MARCH, 1, 0, 0),
                null
        );
        Project project3 = new Project("JohnDoe", "Project - 3", 3, Project.Status.FINISHED.name(), "JohnDoe's Third Project.", "MLPNZD_SYS",
                LocalDateTime.of(2025, Month.JANUARY, 10, 0, 0),
                LocalDateTime.of(2025, Month.JANUARY, 20, 0, 0),
                LocalDateTime.of(2025, Month.JANUARY, 31, 0, 0)
        );
        Project project4 = new Project("JohnDoe", "Project - 4", 4, Project.Status.WRITING.name(), "JohnDoe's Fourth Project.", "MLPNZD_SYS",
                null,
                null,
                null
        );
        projectRepository.saveAll(List.of(project1, project2, project3, project4));

        ConfigTable configTable1 = new ConfigTable(project1.getId(), LBF.getId(), "LBF", "LBF", "Use LBF table in my first project.", 0, 1, "MLPNZD_SYS");
        ConfigTable configTable2 = new ConfigTable(project1.getId(), HLT.getId(), "HLT", "HLT", "Use HLT table in my first project.",  0, 2, "MLPNZD_SYS");
        ConfigTable configTable3 = new ConfigTable(project1.getId(), KBW.getId(), "KBW", "KBW", "Use KBW table in my first project.",  0, 3, "MLPNZD_SYS");
        ConfigTable configTable4 = new ConfigTable(project2.getId(), KBW.getId(), "KBW", "KBW", "Use KBW table in my second project.",  0, 1, "MLPNZD_SYS");
        ConfigTable configTable5 = new ConfigTable(project2.getId(), HLT.getId(), "HLT", "HLT", "Use KBW table in my second project.",  0, 2, "MLPNZD_SYS");
        ConfigTable configTable6 = new ConfigTable(project3.getId(), LBF.getId(), "LBF", "LBF", "Use KBW table in my third project.",  0, 1, "MLPNZD_SYS");

        configTableRepository.saveAll(List.of(configTable1, configTable2, configTable3, configTable4, configTable5, configTable6));
    }
}