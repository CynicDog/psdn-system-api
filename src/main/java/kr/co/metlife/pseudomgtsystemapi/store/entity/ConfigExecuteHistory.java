package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import kr.co.metlife.pseudomgtsystemapi.store.util.StringToLocalDateTimeConverter;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;

/**
 * 가명 처리 이력 Entity를 정의합니다.
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PSEUDO_CONFIG_EXECUTE_HISTORY")
public class ConfigExecuteHistory {

    @Id
    @GeneratedValue(generator = "custom-uuid")
    @GenericGenerator(name = "custom-uuid", strategy = "kr.co.metlife.pseudomgtsystemapi.store.util.CustomUUIDGenerator")
    @Column(name = "PSEUDO_CONFIG_EXECUTE_HISTORY_ID", nullable = false, length = 32)
    private String id;

    /**
     * 가명화 작업 구성 테이블 ID입니다.
     */
    @Column(name = "PSEUDO_CONFIG_TABLE_ID", nullable = false, length = 32)
    private String configTableId;

    /**
     * 가명 처리 결과 파일명입니다.
     */
    @Column(name = "RESULT_FILE_NAME", nullable = false)
    private String resultFileName;

    // 보고서용 컬럼 start
    /**
     * 가명화 대상 데이터 크기입니다.
     */
    @Column(name = "TARGET_DATA_SIZE")
    private Integer targetDataSize;

    /**
     * 가명화 대상 데이터 건수입니다.
     */
    @Column(name = "TARGET_DATA_CNT", columnDefinition = "BIGINT")
    private Integer targetCnt;

    /**
     * 가명화 대상 데이터 설명입니다.
     */
    @Nationalized
    @Column(name = "TARGET_DATA_EXPLANATION", length = 500)
    private String targetDataExplanation;

    /**
     * 가명화 목적입니다.
     */
    @Nationalized
    @Column(name = "PSEUDO_PURPOSE", length = 500)
    private String pseudoPurpose;
    // 보고서용 컬럼 end

    /**
     * 가명 처리 시작 일시입니다.
     */
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "START_TIMESTAMP", nullable = false, columnDefinition = "DATETIME2(3)")
    private LocalDateTime startTimestamp;

    /**
     * 가명 처리 종료 일시입니다.
     */
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "END_TIMESTAMP", nullable = false, columnDefinition = "DATETIME2(3)")
    private LocalDateTime endTimestamp;

    /**
     * 가명 처리 성공 여부입니다.
     */
    @Column(name = "SUCCESS_YN", nullable = false)
    private Boolean successYn;

    /**
     * 가명 처리 실패 원인입니다.
     */
    @Nationalized
    @Column(name = "FAIL_CAUSE", nullable = false, length = 1000)
    private Boolean failCause;
}
