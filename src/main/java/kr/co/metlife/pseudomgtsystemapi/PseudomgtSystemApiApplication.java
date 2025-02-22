package kr.co.metlife.pseudomgtsystemapi;

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
            UserRepository userRepository,
            ProjectRepository projectRepository) {
        return args -> {

            {
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
            }

            /* Pattern 1: 부모-자식 간 관계가 부모에서 정의되고, DB insert 역시 부모 repo에서만 실행되는 패턴 */
            TableColumn TC1 = new TableColumn("COL_1", "COL_1", "VARCHAR");
            TableColumn TC2 = new TableColumn("COL_2", "COL_2", "DECIMAL");
            TableColumn TC3 = new TableColumn("COL_3", "COL_3", "VARCHAR");
            TableColumn TC4 = new TableColumn("COL_4", "COL_4", "VARCHAR");
            TableColumn TC5 = new TableColumn("COL_5", "COL_5", "DECIMAL");
            TableColumn TC6 = new TableColumn("COL_6", "COL_6", "DECIMAL");
            TableColumn TC7 = new TableColumn("COL_7", "COL_7", "VARCHAR");
            TableColumn TC8 = new TableColumn("COL_8", "COL_8", "DECIMAL");
            TableColumn TC9 = new TableColumn("COL_9", "COL_9", "VARCHAR");
            TableColumn TC10 = new TableColumn("COL_10", "COL_10", "DECIMAL");

            Table T1 = new Table("NRS", "NRS");

            T1.addTableColumn(TC1); // 메소드를 통한 부모-자식 관계 정립 (1)
            T1.addTableColumn(TC2);
            T1.addTableColumn(TC3);
            T1.addTableColumns(List.of(TC4, TC5, TC6, TC7, TC8, TC9, TC10)); // 메소드를 통한 부모-자식 관계 정립 (2)

            tableRepository.save(T1);

            TableColumn TC11 = new TableColumn("COL_11", "COL_11", "VARCHAR");
            TableColumn TC12 = new TableColumn("COL_12", "COL_12", "VARCHAR");
            TableColumn TC13 = new TableColumn("COL_13", "COL_13", "VARCHAR");
            TableColumn TC14 = new TableColumn("COL_14", "COL_14", "VARCHAR");
            TableColumn TC15 = new TableColumn("COL_15", "COL_15", "VARCHAR");

            Table T2 = new Table("FDS", "FDS");
            T2.addTableColumns(List.of(TC11, TC12, TC13, TC14, TC15));

            tableRepository.save(T2);

            /* Pattern 2: 부모-자식 간 관계가 자식에서 정의되고, DB insert는 양측 repo에서 실행되는 패턴 */
            User U1 = new User("JohnDoe");
            userRepository.save(U1);

            Project PR1 = new Project("Project-1", 0, "", U1); // 자식 생성자를 통한 부모-자식 관계 정립
            Project PR2 = new Project("Project-2", 1, "", U1);
            Project PR3 = new Project("Project-3", 2, "", U1);
            projectRepository.saveAll(List.of(PR1, PR2, PR3));

            PR1.addConfigTable(T1);
            projectRepository.save(PR1);
        };
    }
}
