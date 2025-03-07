package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import kr.co.metlife.pseudomgtsystemapi.store.util.StringToLocalDateTimeConverter;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * 가명화 작업 구성 규칙 Entity를 정의합니다.
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PSEUDO_CONFIG_RULE")
public class ConfigRule {

    @Id
    @GeneratedValue(generator = "custom-uuid")
    @GenericGenerator(name = "custom-uuid", strategy = "kr.co.metlife.pseudomgtsystemapi.store.util.CustomUUIDGenerator")
    @Column(name = "PSEUDO_CONFIG_RULE_ID", nullable = false, length = 32)
    private String id;

    /**
     * 가명화 작업 구성 컬럼 ID입니다.
     */
    @Column(name = "PSEUDO_CONFIG_COLUMN_ID", nullable = false, length = 32)
    private String configColumnId;

    /**
     * 가명화 규칙 마스터 ID입니다.
     */
    @Column(name = "PSEUDO_RULE_ID", nullable = false, length = 32)
    private String ruleId;

    /**
     * 규칙 속성명입니다.
     */
    @Column(name = "RULE_ATTRIBUTE_NAME", nullable = false, length = 50)
    private String attributeName;

    /**
     * 규칙 한글명입니다.
     */
    @Nationalized
    @Column(name = "RULE_KOREAN_NAME", nullable = false, length = 50)
    private String nameKorean;

    /**
     * 규칙 영문명입니다.
     */
    @Column(name = "RULE_ENGLISH_NAME", nullable = false, length = 50)
    private String nameEnglish;

    /**
     * 규칙 설명입니다.
     */
    @Nationalized
    @Column(name = "RULE_EXPLANATION")
    private String explanation;

    /**
     * 규칙 조회 순서입니다.
     */
    @Column(name = "RULE_SEQUENCE")
    private Integer sequence;

    /**
     * 규칙 적용 순서입니다.
     */
    @Column(name = "RULE_APPLY_SEQUENCE")
    private Integer applySequence;

    /**
     * 데이터 입력 사용자명입니다.
     */
    @Column(name = "INPUT_USERNAME", nullable = false, length = 120)
    private String inputUsername;

    /**
     * 데이터 입력 일시입니다.
     */
    @CreationTimestamp
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "INPUT_TIMESTAMP", nullable = false, columnDefinition = "DATETIME2(3)")
    private LocalDateTime inputTimestamp;

    /**
     * 데이터 수정 사용자명입니다.
     */
    @Column(name = "UPDATE_USERNAME", length = 120)
    private String updateUsername;

    /**
     * 데이터 수정 일시입니다.
     */
    @UpdateTimestamp
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "UPDATE_TIMESTAMP", columnDefinition = "DATETIME2(3)")
    private LocalDateTime updateTimestamp;
}
