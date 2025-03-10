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
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        List<Rule> rules = List.of(
                Rule.builder().attributeName("suppression").nameKorean("삭제").nameEnglish("Suppression")
                        .sequence(1).explanation("원본정보에서 개인정보를 단순 삭제 (칼럼 삭제)").inputUsername("MLPNZD_SYS").build(),

                Rule.builder().attributeName("masking").nameKorean("마스킹").nameEnglish("Masking")
                        .sequence(2).explanation("특정 항목의 일부 또는 전부를 공백 또는 문자(‘ * ’, ‘ _ ’ 등이나 전각 기호)로 대체").inputUsername("MLPNZD_SYS").build(),

                Rule.builder().attributeName("outlier_generalization").nameKorean("특이치 범주화").nameEnglish("Outlier Generalization")
                        .sequence(3).explanation("분포상의 특이성으로 인해 식별이 가능한 데이터 건을 일반화를 적용하여 식별성을 낮추는 기법").inputUsername("MLPNZD_SYS").build(),

                Rule.builder().attributeName("top_down_coding").nameKorean("상하단 코딩").nameEnglish("Top Down Coding")
                        .sequence(4).explanation("상하위, 상위 또는 하위 등의 검증 유형에 따른 분위수 내 해당하는 데이터를 분위 경계값으로 대체하는 기법").inputUsername("MLPNZD_SYS").build(),

                Rule.builder().attributeName("data_range").nameKorean("범위 방법").nameEnglish("Data Range")
                        .sequence(5).explanation("수치 데이터를 임의의 수 기준의 범위(range)로 설정하는 기법으로, 해당 값의 범위 또는 구간(interval)으로 표현").inputUsername("MLPNZD_SYS").build(),

                Rule.builder().attributeName("partial_suppression").nameKorean("부분 삭제").nameEnglish("Partial Suppression")
                        .sequence(6).explanation("개인정보 칼럼 전체를 삭제하는 방식이 아니라 레코드 데이터의 일부를 삭제").inputUsername("MLPNZD_SYS").build(),

                Rule.builder().attributeName("top_down_nullification").nameKorean("로컬 무효화").nameEnglish("Local Nullify")
                        .sequence(7).explanation("금액, 나이 등 수치형 데이터에서 나타나는 극단값을 가지는 데이터를 감지하여 해당 수치를 무효화(null 처리)하거나, 해당 레코드를 삭제하는 기법").inputUsername("MLPNZD_SYS").build(),

                Rule.builder().attributeName("group_aggregation").nameKorean("그룹 총계").nameEnglish("Group Aggregation")
                        .sequence(8).explanation("정보집합물 내 하나 또는 그 이상의 행 항목에 해당하는 특정 열 항목을 총계처리").inputUsername("MLPNZD_SYS").build(),

                Rule.builder().attributeName("rounding").nameKorean("일반 라운딩").nameEnglish("Normal Rounding")
                        .sequence(9).explanation("올림, 내림, 반올림 등의 기준을 적용하여 집계 처리하는 방법으로, 일반적으로 세세한 정보보다는 전체 통계정보가 필요한 경우 많이 사용").inputUsername("MLPNZD_SYS").build(),

                Rule.builder().attributeName("random_rounding").nameKorean("랜덤 라운딩").nameEnglish("Random Rounding")
                        .sequence(10).explanation("수치 데이터를 임의의 수인 자리 수, 실제 수 기준으로 올림(round up) 또는 내림(round down)하는 기법").inputUsername("MLPNZD_SYS").build(),

                Rule.builder().attributeName("noise_addition").nameKorean("잡음 추가").nameEnglish("Noise Addition")
                        .sequence(11).explanation("개인정보에 임의의 숫자 등 잡음을 추가하는 방법").inputUsername("MLPNZD_SYS").build(),

                Rule.builder().attributeName("permutation").nameKorean("순열").nameEnglish("Permutation")
                        .sequence(12).explanation("개인정보를 다른 행 항목의 정보와 무작위로 순서를 변경하여 전체 정보에 대한 변경 없이 특정 정보가 해당 개인과 연결되지 않도록 하는 방법").inputUsername("MLPNZD_SYS").build(),

                Rule.builder().attributeName("mapping").nameKorean("문자 대체").nameEnglish("Letters Replacement")
                        .sequence(13).explanation("식별자에 해당하는 값들을 정해진 사전에 등재된 단어로 대체하여 자세한 개인정보를 숨기는 방법").inputUsername("MLPNZD_SYS").build(),

                Rule.builder().attributeName("random_selection_replacement").nameKorean("단어 사전 무작위 추출").nameEnglish("Random Selection Replacement")
                        .sequence(14).explanation("정보집합물 내 하나 또는 그 이상의 행 항목에 해당하는 특정 열 항목을 총계처리").inputUsername("MLPNZD_SYS").build()
        );
        ruleRepository.saveAll(rules);

        List<Parameter> parameters = List.of(
                Parameter.builder().attributeName("alternative").nameKorean("검증 유형").nameEnglish("Alternative")
                        .type("code").useCodeGroupId("").defaultValue("two_side")
                        .explanation("검증 유형 - 상하위(two-side), 하위(less), 상위(greater)")
                        .inputUsername("MLPNZD_SYS").build(),

                Parameter.builder().attributeName("binning_length").nameKorean("카운트 구간 길이").nameEnglish("Counting Bin Size")
                        .type("int").useCodeGroupId("").defaultValue("0")
                        .explanation("연속형 데이터에 대하여 특이치 임계치를 산정하기 위해 설정되는 카운트 구간 길이")
                        .inputUsername("MLPNZD_SYS").build(),

                Parameter.builder().attributeName("chaos_level").nameKorean("무작위 수준").nameEnglish("Chaos Level")
                        .type("int").useCodeGroupId("").defaultValue("")
                        .explanation("잡음 추가 시 적용되는 무작위 수준")
                        .inputUsername("MLPNZD_SYS").build(),

                Parameter.builder().attributeName("grouping_columns").nameKorean("연관 칼럼").nameEnglish("Grouping Column")
                        .type("string").useCodeGroupId("").defaultValue("")
                        .explanation("그루핑 시 사용되는 연관 칼럼")
                        .inputUsername("MLPNZD_SYS").build(),

                Parameter.builder().attributeName("mapping_definition").nameKorean("원본 값 - 대체 값 정의").nameEnglish("Mapping Definition")
                        .type("mapping").useCodeGroupId("").defaultValue("")
                        .explanation("원본 데이터를 대체하는 문자")
                        .inputUsername("MLPNZD_SYS").build(),

                Parameter.builder().attributeName("mask_char").nameKorean("마스킹 문자").nameEnglish("Masking Character")
                        .type("string").useCodeGroupId("").defaultValue("")
                        .explanation("마스킹 처리에 사용될 문자")
                        .inputUsername("MLPNZD_SYS").build(),

                Parameter.builder().attributeName("mask_range").nameKorean("마스킹 범위").nameEnglish("Masking Range")
                        .type("range").useCodeGroupId("").defaultValue("0")
                        .explanation("마스킹 처리 범위")
                        .inputUsername("MLPNZD_SYS").build(),

                Parameter.builder().attributeName("percentile").nameKorean("분위수").nameEnglish("Percentile")
                        .type("int").useCodeGroupId("").defaultValue("5")
                        .explanation("규칙 적용에 사용할 분위수 예) 상하위 5%")
                        .inputUsername("MLPNZD_SYS").build(),

                Parameter.builder().attributeName("re_identification_yn").nameKorean("재식별화 키 여부").nameEnglish("Re-Identification YN")
                        .type("bool").useCodeGroupId("").defaultValue("true")
                        .explanation("해당 칼럼의 데이터가 삭제된 후 재식별키에 사용되는지 여부")
                        .inputUsername("MLPNZD_SYS").build(),

                Parameter.builder().attributeName("record_deletion").nameKorean("레코드 삭제 여부").nameEnglish("Record Deletion YN")
                        .type("bool").useCodeGroupId("").defaultValue("false")
                        .explanation("로컬 삭제 시 레코드 삭제 여부")
                        .inputUsername("MLPNZD_SYS").build(),

                Parameter.builder().attributeName("replacement_statistic").nameKorean("대체 통계값").nameEnglish("Replacement Statistic")
                        .type("code").useCodeGroupId("").defaultValue("mean")
                        .explanation("총계 처리에 사용될 통계값 - 평균값(mean), 중앙값(median), 최빈값(mode)")
                        .inputUsername("MLPNZD_SYS").build(),

                Parameter.builder().attributeName("rounding_mode").nameKorean("라운딩 모드").nameEnglish("Rounding Mode")
                        .type("code").useCodeGroupId("").defaultValue("nearest")
                        .explanation("라운딩 모드 - 올림(up), 내림(down), 반올림(nearest)")
                        .inputUsername("MLPNZD_SYS").build(),

                Parameter.builder().attributeName("rounding_position").nameKorean("라운딩 자리수").nameEnglish("Rounding Position")
                        .type("int").useCodeGroupId("").defaultValue("")
                        .explanation("라운딩 자리수")
                        .inputUsername("MLPNZD_SYS").build(),

                Parameter.builder().attributeName("rounding_size").nameKorean("데이터 구간 배수").nameEnglish("Binning Size")
                        .type("int").useCodeGroupId("").defaultValue("3")
                        .explanation("범위 방법에 사용될 배수")
                        .inputUsername("MLPNZD_SYS").build(),

                Parameter.builder().attributeName("scope_specification").nameKorean("부분 삭제 범위").nameEnglish("Partial Suppression Range")
                        .type("range").useCodeGroupId("").defaultValue("0")
                        .explanation("부분 삭제 범위")
                        .inputUsername("MLPNZD_SYS").build(),

                Parameter.builder().attributeName("selection_list").nameKorean("단어 사전").nameEnglish("Replacement Dictionary")
                        .type("list").useCodeGroupId("").defaultValue("")
                        .explanation("단어 사전 무작위 추출에 사용될 사전")
                        .inputUsername("MLPNZD_SYS").build(),

                Parameter.builder().attributeName("threshold_criterion").nameKorean("임계 기준").nameEnglish("Threshold Criteria")
                        .type("code").useCodeGroupId("").defaultValue("count")
                        .explanation("특이치 범주화 기법 적용 시 사용되는 임계 기준 - 비율(ratio), 건수(count)")
                        .inputUsername("MLPNZD_SYS").build(),

                Parameter.builder().attributeName("threshold_value").nameKorean("임계 값").nameEnglish("Threshold Value")
                        .type("float").useCodeGroupId("").defaultValue("1")
                        .explanation("특이치 범주화 기법 적용 시 사용되는 임계 값")
                        .inputUsername("MLPNZD_SYS").build()
        );

        parameterRepository.saveAll(parameters);

        /* Mock Table "LBF" insert */
        Table LBF = Table.builder()
                .name("LBF")
                .logicalName("LBF")
                .inputUsername("MLPNZD_SYS")
                .build();

        tableRepository.save(LBF);
        List<Column> lbfColumns = IntStream.range(0, 50)
                .mapToObj(i -> Column.builder()
                        .tableId(LBF.getId())
                        .name(String.format("col-%s", i))
                        .logicalName(String.format("col-logical-%s", i))
                        .dataType((i % 2 == 0) ? "NVARCHAR" : "DECIMAL")
                        .inputUsername("MLPNZD_SYS")
                        .build())
                .collect(Collectors.toList());
        columnRepository.saveAll(lbfColumns);

        /* Mock Table "HLT" insert */
        Table HLT = Table.builder()
                .name("HLT")
                .logicalName("HLT")
                .inputUsername("MLPNZD_SYS")
                .build();

        tableRepository.save(HLT);
        List<Column> hltColumns = IntStream.range(0, 60)
                .mapToObj(i -> Column.builder()
                        .tableId(HLT.getId())
                        .name(String.format("col-%s", i))
                        .logicalName(String.format("col-logical-%s", i))
                        .dataType((i % 2 == 0) ? "NVARCHAR" : "DECIMAL")
                        .inputUsername("MLPNZD_SYS")
                        .build())
                .collect(Collectors.toList());
        columnRepository.saveAll(hltColumns);

        /* Mock Table "KBW" insert */
        Table KBW = Table.builder()
                .name("KBW")
                .logicalName("KBW")
                .inputUsername("MLPNZD_SYS")
                .build();

        tableRepository.save(KBW);
        List<Column> kbwColumns = IntStream.range(0, 40)
                .mapToObj(i -> Column.builder()
                        .tableId(KBW.getId())
                        .name(String.format("col-%s", i))
                        .logicalName(String.format("col-logical-%s", i))
                        .dataType((i % 2 == 0) ? "NVARCHAR" : "DECIMAL")
                        .inputUsername("MLPNZD_SYS")
                        .build())
                .collect(Collectors.toList());
        columnRepository.saveAll(kbwColumns);


        { /* Mock Data for `JohnDoe` */
            /* Mock Data for `JohnDoe` */
            List<Project> projects = List.of(
                    Project.builder()
                            .username("JohnDoe")
                            .name("Project - 1")
                            .sequence(0)
                            .status(Project.Status.APPROVED.name())
                            .explanation("JohnDoe's First Project.")
                            .inputUsername("MLPNZD_SYS")
                            .approveTimestamp(LocalDateTime.of(2025, Month.JANUARY, 20, 0, 0))
                            .startTimestamp(LocalDateTime.of(2025, Month.FEBRUARY, 1, 0, 0))
                            .finishTimestamp(null)
                            .build(),

                    Project.builder()
                            .username("JohnDoe")
                            .name("Project - 2")
                            .sequence(1)
                            .status(Project.Status.PENDING.name())
                            .explanation("JohnDoe's Second Project.")
                            .inputUsername("MLPNZD_SYS")
                            .approveTimestamp(null)
                            .startTimestamp(LocalDateTime.of(2025, Month.MARCH, 1, 0, 0))
                            .finishTimestamp(null)
                            .build(),

                    Project.builder()
                            .username("JohnDoe")
                            .name("Project - 3")
                            .sequence(2)
                            .status(Project.Status.FINISHED.name())
                            .explanation("JohnDoe's Third Project.")
                            .inputUsername("MLPNZD_SYS")
                            .approveTimestamp(LocalDateTime.of(2025, Month.JANUARY, 10, 0, 0))
                            .startTimestamp(LocalDateTime.of(2025, Month.JANUARY, 20, 0, 0))
                            .finishTimestamp(LocalDateTime.of(2025, Month.JANUARY, 31, 0, 0))
                            .build(),

                    Project.builder()
                            .username("JohnDoe")
                            .name("Project - 4")
                            .sequence(3)
                            .status(Project.Status.WRITING.name())
                            .explanation("JohnDoe's Fourth Project.")
                            .inputUsername("MLPNZD_SYS")
                            .approveTimestamp(null)
                            .startTimestamp(null)
                            .finishTimestamp(null)
                            .build()
            );
            projectRepository.saveAll(projects);

            List<ConfigTable> configTables = List.of(
                    ConfigTable.builder()
                            .projectId(projects.get(0).getId())
                            .tableId(LBF.getId())
                            .name("LBF")
                            .logicalName("LBF")
                            .explanation("Use LBF table in my first project.")
                            .iteration(0)
                            .sequence(1)
                            .inputUsername("MLPNZD_SYS")
                            .build(),

                    ConfigTable.builder()
                            .projectId(projects.get(0).getId())
                            .tableId(HLT.getId())
                            .name("HLT")
                            .logicalName("HLT")
                            .explanation("Use HLT table in my first project.")
                            .iteration(0)
                            .sequence(2)
                            .inputUsername("MLPNZD_SYS")
                            .build(),

                    ConfigTable.builder()
                            .projectId(projects.get(0).getId())
                            .tableId(KBW.getId())
                            .name("KBW")
                            .logicalName("KBW")
                            .explanation("Use KBW table in my first project.")
                            .iteration(0)
                            .sequence(3)
                            .inputUsername("MLPNZD_SYS")
                            .build(),

                    ConfigTable.builder()
                            .projectId(projects.get(1).getId())
                            .tableId(KBW.getId())
                            .name("KBW")
                            .logicalName("KBW")
                            .explanation("Use KBW table in my second project.")
                            .iteration(0)
                            .sequence(1)
                            .inputUsername("MLPNZD_SYS")
                            .build(),

                    ConfigTable.builder()
                            .projectId(projects.get(1).getId())
                            .tableId(HLT.getId())
                            .name("HLT")
                            .logicalName("HLT")
                            .explanation("Use KBW table in my second project.")
                            .iteration(0)
                            .sequence(2)
                            .inputUsername("MLPNZD_SYS")
                            .build(),

                    ConfigTable.builder()
                            .projectId(projects.get(2).getId())
                            .tableId(LBF.getId())
                            .name("LBF")
                            .logicalName("LBF")
                            .explanation("Use KBW table in my third project.")
                            .iteration(0)
                            .sequence(1)
                            .inputUsername("MLPNZD_SYS")
                            .build()
            );
            configTableRepository.saveAll(configTables);
        }

        { /* Mock Data for `kyrsang0801` */
            /* Mock Data for `kyrsang0801` */
            List<Project> kyrsangProjects = List.of(
                    Project.builder()
                            .username("kyrsang0801")
                            .name("Project - 1")
                            .sequence(0)
                            .status(Project.Status.APPROVED.name())
                            .explanation("kyrsang0801's First Project.")
                            .inputUsername("MLPNZD_SYS")
                            .approveTimestamp(LocalDateTime.of(2025, Month.JANUARY, 20, 0, 0))
                            .startTimestamp(LocalDateTime.of(2025, Month.FEBRUARY, 1, 0, 0))
                            .finishTimestamp(null)
                            .build(),

                    Project.builder()
                            .username("kyrsang0801")
                            .name("Project - 2")
                            .sequence(1)
                            .status(Project.Status.PENDING.name())
                            .explanation("kyrsang0801's Second Project.")
                            .inputUsername("MLPNZD_SYS")
                            .approveTimestamp(null)
                            .startTimestamp(LocalDateTime.of(2025, Month.MARCH, 1, 0, 0))
                            .finishTimestamp(null)
                            .build(),

                    Project.builder()
                            .username("kyrsang0801")
                            .name("Project - 3")
                            .sequence(2)
                            .status(Project.Status.FINISHED.name())
                            .explanation("kyrsang0801's Third Project.")
                            .inputUsername("MLPNZD_SYS")
                            .approveTimestamp(LocalDateTime.of(2025, Month.JANUARY, 10, 0, 0))
                            .startTimestamp(LocalDateTime.of(2025, Month.JANUARY, 20, 0, 0))
                            .finishTimestamp(LocalDateTime.of(2025, Month.JANUARY, 31, 0, 0))
                            .build(),

                    Project.builder()
                            .username("kyrsang0801")
                            .name("Project - 4")
                            .sequence(3)
                            .status(Project.Status.WRITING.name())
                            .explanation("kyrsang0801's Fourth Project.")
                            .inputUsername("MLPNZD_SYS")
                            .approveTimestamp(null)
                            .startTimestamp(null)
                            .finishTimestamp(null)
                            .build()
            );

            projectRepository.saveAll(kyrsangProjects);

            List<ConfigTable> kyrsangConfigTables = List.of(
                    ConfigTable.builder()
                            .projectId(kyrsangProjects.get(0).getId())
                            .tableId(LBF.getId())
                            .name("LBF")
                            .logicalName("LBF")
                            .explanation("Use LBF table in my first project.")
                            .iteration(0)
                            .sequence(1)
                            .inputUsername("MLPNZD_SYS")
                            .build(),

                    ConfigTable.builder()
                            .projectId(kyrsangProjects.get(0).getId())
                            .tableId(HLT.getId())
                            .name("HLT")
                            .logicalName("HLT")
                            .explanation("Use HLT table in my first project.")
                            .iteration(0)
                            .sequence(2)
                            .inputUsername("MLPNZD_SYS")
                            .build(),

                    ConfigTable.builder()
                            .projectId(kyrsangProjects.get(0).getId())
                            .tableId(KBW.getId())
                            .name("KBW")
                            .logicalName("KBW")
                            .explanation("Use KBW table in my first project.")
                            .iteration(0)
                            .sequence(3)
                            .inputUsername("MLPNZD_SYS")
                            .build(),

                    ConfigTable.builder()
                            .projectId(kyrsangProjects.get(1).getId())
                            .tableId(KBW.getId())
                            .name("KBW")
                            .logicalName("KBW")
                            .explanation("Use KBW table in my second project.")
                            .iteration(0)
                            .sequence(1)
                            .inputUsername("MLPNZD_SYS")
                            .build(),

                    ConfigTable.builder()
                            .projectId(kyrsangProjects.get(1).getId())
                            .tableId(HLT.getId())
                            .name("HLT")
                            .logicalName("HLT")
                            .explanation("Use KBW table in my second project.")
                            .iteration(0)
                            .sequence(2)
                            .inputUsername("MLPNZD_SYS")
                            .build(),

                    ConfigTable.builder()
                            .projectId(kyrsangProjects.get(2).getId())
                            .tableId(LBF.getId())
                            .name("LBF")
                            .logicalName("LBF")
                            .explanation("Use KBW table in my third project.")
                            .iteration(0)
                            .sequence(1)
                            .inputUsername("MLPNZD_SYS")
                            .build()
            );
            configTableRepository.saveAll(kyrsangConfigTables);
        }
    }
}