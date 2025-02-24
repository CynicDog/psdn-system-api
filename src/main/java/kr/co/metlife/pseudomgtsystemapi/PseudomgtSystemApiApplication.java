package kr.co.metlife.pseudomgtsystemapi;

import jakarta.transaction.Transactional;
import kr.co.metlife.pseudomgtsystemapi.store.entity.*;
import kr.co.metlife.pseudomgtsystemapi.store.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PseudomgtSystemApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PseudomgtSystemApiApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(
            RuleRepository ruleRepository,
            ParameterRepository parameterRepository,
            TableRepository tableRepository,
            TableColumnRepository tableColumnRepository,
            UserRepository userRepository,
            ProjectRepository projectRepository,
            ConfigTableRepository configTableRepository,
            ConfigTableColumnRepository configTableColumnRepository,
            ConfigRuleRepository configRuleRepository,
            ConfigParameterRepository configParameterRepository
    ) {
        return args -> {

            /* 규칙 / 파라미터 정의 */
            Rule R1 = new Rule("suppression", "삭제", "Suppression", "");
            Rule R2 = new Rule("masking", "마스킹", "Masking", "");
            Rule R3 = new Rule("data_range", "범위방법", "Data Range", "");
            Rule R4 = new Rule("outlier_generalization", "특이치범주화", "Outlier Generalization", "");
            Rule R5 = new Rule("top_down_coding", "상하단코딩", "Top-Down Coding", "");
            Rule R6 = new Rule("partial_suppression", "부분삭제", "Partial Suppression", "");
            Rule R7 = new Rule("locality_nullify", "로컬무효화", "Locality Nullify", "");
            Rule R8 = new Rule("group_aggregation", "그룹총계", "Group Aggregation", "");
            Rule R9 = new Rule("rounding", "일반라운딩", "Rounding", "");
            Rule R10 = new Rule("random_rounding", "랜덤라운딩", "Random Rounding", "");
            Rule R11 = new Rule("noise_addition", "잡음추가", "Noise Addition", "");
            Rule R12 = new Rule("permutation", "순열", "Permutation", "");
            Rule R13 = new Rule("letters_replacement", "문자대체", "Letters Replacement", "");
            Rule R14 = new Rule("random_selection_replacement", "단어사전무작위추출", "Random Selection Replacement", "");
            ruleRepository.saveAll(List.of(R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14));

            Parameter P1 = new Parameter("re_identification_yn", "재식별화키여부", "Re-Identification YN", "Boolean", "true", "");
            Parameter P2 = new Parameter("replacement_statistics", "대체통계값", "Replacement Statistic", "Boolean", "true", "");
            Parameter P3 = new Parameter("grouping_column", "연관칼럼", "Grouping Column", "String", "", "");
            Parameter P4 = new Parameter("rounding_position", "라운딩위치", "Rounding Position", "Float", "", "");
            Parameter P5 = new Parameter("rounding_mode", "라운딩모드", "Rounding Mode", "CODE_P5", "", "");
            Parameter P6 = new Parameter("chaos_level", "무작위수준", "Chaos Level", "Integer", "", "");
            Parameter P7 = new Parameter("scope_specification", "범위지정", "Scope Specification", "String", "", "");
            Parameter P8 = new Parameter("replacement_letter", "대체문자", "Replacement Letter", "String", "", "");
            Parameter P9 = new Parameter("threshold_criteria", "임계기준", "Threshold Criteria", "CODE_P9", "", "");
            Parameter P10 = new Parameter("threshold_value", "임계값", "Threshold Value", "Float", "", "");
            Parameter P11 = new Parameter("random_seed", "랜덤시드", "Random Seed", "Integer", "", "");
            Parameter P12 = new Parameter("data_range_multiple", "데이터구간배수", "Data Range Multiple", "Integer", "", "");
            Parameter P13 = new Parameter("counting_bin_size", "카운트구간길이", "Counting Bin Size", "Integer", "", "");
            Parameter P14 = new Parameter("mapping_definition", "문자대체정의", "Mapping Definition", "String", "", "");
            Parameter P15 = new Parameter("selection_dictionary", "단어추출사전", "Selection Dictionary", "String", "", "");
            Parameter P16 = new Parameter("test_alternative", "검증유형", "Test Alternative", "CODE_P16", "", "");
            Parameter P17 = new Parameter("percentile_criteria", "분위기준", "Percentile Criteria", "CODE_P17", "", "");
            Parameter P18 = new Parameter("percentile_value", "분위값", "Percentile Value", "Float", "", "");
            Parameter P19 = new Parameter("record_deletion_yn", "레코드삭제여부", "Record Deletion YN", "Boolean", "", "");
            parameterRepository.saveAll(List.of(P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19));

            /* 대상 테이블 / 칼럼 정의 - 1 */
            Table T1 = new Table("NRS", "NRS");
            tableRepository.save(T1);
            TableColumn TC1 = new TableColumn(T1.getId(), "COL_1", "COL_1", "VARCHAR");
            TableColumn TC2 = new TableColumn(T1.getId(), "COL_2", "COL_2", "DECIMAL");
            TableColumn TC3 = new TableColumn(T1.getId(), "COL_3", "COL_3", "VARCHAR");
            TableColumn TC4 = new TableColumn(T1.getId(), "COL_4", "COL_4", "VARCHAR");
            TableColumn TC5 = new TableColumn(T1.getId(), "COL_5", "COL_5", "DECIMAL");
            TableColumn TC6 = new TableColumn(T1.getId(), "COL_6", "COL_6", "DECIMAL");
            TableColumn TC7 = new TableColumn(T1.getId(), "COL_7", "COL_7", "VARCHAR");
            TableColumn TC8 = new TableColumn(T1.getId(), "COL_8", "COL_8", "DECIMAL");
            TableColumn TC9 = new TableColumn(T1.getId(), "COL_9", "COL_9", "VARCHAR");
            TableColumn TC10 = new TableColumn(T1.getId(), "COL_10", "COL_10", "DECIMAL");
            tableColumnRepository.saveAll(List.of(TC1, TC2, TC3, TC4, TC5, TC6, TC7, TC8, TC9, TC10));

            /* 대상 테이블 / 칼럼 정의 - 2 */
            Table T2 = new Table("FDS", "FDS");
            tableRepository.save(T2);
            TableColumn TC11 = new TableColumn(T2.getId(), "COL_11", "COL_11", "VARCHAR");
            TableColumn TC12 = new TableColumn(T2.getId(), "COL_12", "COL_12", "DECIMAL");
            TableColumn TC13 = new TableColumn(T2.getId(), "COL_13", "COL_13", "VARCHAR");
            TableColumn TC14 = new TableColumn(T2.getId(), "COL_14", "COL_14", "DECIMAL");
            TableColumn TC15 = new TableColumn(T2.getId(), "COL_15", "COL_15", "DECIMAL");
            tableColumnRepository.saveAll(List.of(TC11, TC12, TC13, TC14, TC15));


            /* 사용자 정의 */
            User U1 = new User("JohnDoe");
            userRepository.save(U1);

            /* 사용자의 프로젝트 생성 */
            Project PR1 = new Project(U1.getId(), "Project-1", 0, "");
            Project PR2 = new Project(U1.getId(), "Project-2", 1, "");
            Project PR3 = new Project(U1.getId(), "Project-3", 2, "");
            projectRepository.saveAll(List.of(PR1, PR2, PR3));

            /* 사용자의 프로젝트 별 설정 테이블 할당 */

            // Project 1 - NRS, FDS
            ConfigTable CT1 = new ConfigTable(PR1.getId(), T1.getId(), T1.getName(), T1.getLogicalName(), 0, 0);
            ConfigTable CT2 = new ConfigTable(PR1.getId(), T1.getId(), T2.getName(), T2.getLogicalName(), 0, 1);

            // Project 2 - NRS
            ConfigTable CT3 = new ConfigTable(PR2.getId(), T1.getId(), T1.getName(), T1.getLogicalName(), 0, 0);

            // Project 3 - FDS
            ConfigTable CT4 = new ConfigTable(PR3.getId(), T1.getId(), T2.getName(), T2.getLogicalName(), 0, 0);
            configTableRepository.saveAll(List.of(CT1, CT2, CT3, CT4));


            /* 사용자의 설정 테이블 칼럼 지정 */
            // Project 1 - NRS - 1 ~ 5 Columns
            ConfigTableColumn CTC1 = new ConfigTableColumn(CT1.getId(), CT1.getIteration(), TC1.getId(), TC1.getName(), TC1.getLogicalName(), TC1.getDataType());
            ConfigTableColumn CTC2 = new ConfigTableColumn(CT1.getId(), CT1.getIteration(), TC2.getId(), TC2.getName(), TC2.getLogicalName(), TC2.getDataType());
            ConfigTableColumn CTC3 = new ConfigTableColumn(CT1.getId(), CT1.getIteration(), TC3.getId(), TC3.getName(), TC3.getLogicalName(), TC3.getDataType());
            ConfigTableColumn CTC4 = new ConfigTableColumn(CT1.getId(), CT1.getIteration(), TC4.getId(), TC4.getName(), TC4.getLogicalName(), TC4.getDataType());
            ConfigTableColumn CTC5 = new ConfigTableColumn(CT1.getId(), CT1.getIteration(), TC5.getId(), TC5.getName(), TC5.getLogicalName(), TC5.getDataType());
            configTableColumnRepository.saveAll(List.of(CTC1, CTC2, CTC3, CTC4, CTC5));
            {
                // Project 1 - NRS - Column 1 (VARCHAR) 마스킹(R2) 적용
                ConfigRule CTC1_CR2 = new ConfigRule(CT1.getId(), CT1.getIteration(), CTC1.getId(), 0, R2.getId());
                configRuleRepository.save(CTC1_CR2);
                // Project 1 - NRS - Column 1 (VARCHAR) 마스킹 파라미터(P7, P8) 지정
                ConfigParameter CTC1_CR2_CP7 = new ConfigParameter(CT1.getId(), CT1.getIteration(), CTC1.getColumnId(), CTC1_CR2.getId(), "-2", P7.getId());
                ConfigParameter CTC1_CR2_CP8 = new ConfigParameter(CT1.getId(), CT1.getIteration(), CTC1.getColumnId(), CTC1_CR2.getId(), "*", P8.getId());
                configParameterRepository.saveAll(List.of(CTC1_CR2_CP7, CTC1_CR2_CP8));
            }
            {
                // Project 1 - NRS - Column 2 (DECIMAL) 범위방법(R3) 적용
                ConfigRule CTC2_CR3 = new ConfigRule(CT1.getId(), CT1.getIteration(), CTC2.getId(), 0, R3.getId());
                configRuleRepository.save(CTC2_CR3);
                // Project 1 - NRS - Column 2 (VARCHAR) 범위방법 파라미터(P12) 지정
                ConfigParameter CTC2_CR3_CP12 = new ConfigParameter(CT1.getId(), CT1.getIteration(), CTC2.getColumnId(), CTC2_CR3.getId(), "3", P12.getId());
                configParameterRepository.save(CTC2_CR3_CP12);
            }
            {
                // Project 1 - NRS - Column 3 (VARCHAR) 마스킹(R2) 적용
                ConfigRule CTC3_CR2 = new ConfigRule(CT1.getId(), CT1.getIteration(), CTC3.getId(), 0, R2.getId());
                configRuleRepository.save(CTC3_CR2);
                // Project 1 - NRS - Column 3 (VARCHAR) 마스킹 파라미터(P7, P8) 지정
                ConfigParameter CTC3_CR2_CP7 = new ConfigParameter(CT1.getId(), CT1.getIteration(), CTC3.getColumnId(), CTC3_CR2.getId(), "-2", P7.getId());
                ConfigParameter CTC3_CR2_CP8 = new ConfigParameter(CT1.getId(), CT1.getIteration(), CTC3.getColumnId(), CTC3_CR2.getId(), "*", P8.getId());
                configParameterRepository.saveAll(List.of(CTC3_CR2_CP7, CTC3_CR2_CP8));
            }
            {
                // Project 1 - NRS - Column 4 (VARCHAR) 마스킹(R2) 적용
                ConfigRule CTC4_CR2 = new ConfigRule(CT1.getId(), CT1.getIteration(), CTC4.getId(), 0, R2.getId());
                configRuleRepository.save(CTC4_CR2);
                // Project 1 - NRS - Column 4 (VARCHAR) 마스킹 파라미터(P7, P8) 지정
                ConfigParameter CTC4_CR2_CP7 = new ConfigParameter(CT1.getId(), CT1.getIteration(), CTC4.getColumnId(), CTC4_CR2.getId(), "-2", P7.getId());
                ConfigParameter CTC4_CR2_CP8 = new ConfigParameter(CT1.getId(), CT1.getIteration(), CTC4.getColumnId(), CTC4_CR2.getId(), "*", P8.getId());
                configParameterRepository.saveAll(List.of(CTC4_CR2_CP7, CTC4_CR2_CP8));
            }
            {
                // Project 1 - NRS - Column 5 (DECIMAL) 범위방법(R3) 적용
                ConfigRule CTC5_CR3 = new ConfigRule(CT1.getId(), CT1.getIteration(), CTC5.getId(), 0, R3.getId());
                configRuleRepository.save(CTC5_CR3);
                // Project 1 - NRS - Column 5 (VARCHAR) 범위방법 파라미터(P12) 지정
                ConfigParameter CTC5_CR3_CP12 = new ConfigParameter(CT1.getId(), CT1.getIteration(), CTC5.getColumnId(), CTC5_CR3.getId(), "3", P12.getId());
                configParameterRepository.save(CTC5_CR3_CP12);
            }
        };
    }
}
