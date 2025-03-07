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
 * 가명화 작업 구성 컬럼 Entity를 정의합니다.
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PSEUDO_CONFIG_COLUMN")
public class ConfigColumn {

    @Id
    @GeneratedValue(generator = "custom-uuid")
    @GenericGenerator(name = "custom-uuid", strategy = "kr.co.metlife.pseudomgtsystemapi.store.util.CustomUUIDGenerator")
    @Column(name = "PSEUDO_CONFIG_COLUMN_ID", nullable = false, length = 32)
    private String id;

    /**
     * 가명화 작업 구성 테이블 ID입니다.
     */
    @Column(name = "PSEUDO_CONFIG_TABLE_ID", nullable = false, length = 32)
    private String configTableId;

    /**
     * 컬럼 메타 ID입니다.
     */
    @Column(name = "PSEUDO_COLUMN_ID", nullable = false, length = 32)
    private String columnId;

    /**
     * 컬럼명입니다.
     */
    @Column(name = "COLUMN_NAME", length = 200)
    private String name;

    /**
     * 컬럼 논리명입니다.
     */
    @Nationalized
    @Column(name = "COLUMN_LOGICAL_NAME", nullable = false, length = 400)
    private String logicalName;

    /**
     * 컬럼 자료형입니다.
     */
    @Column(name = "COLUMN_DATA_TYPE", length = 20)
    private String dataType;

    /**
     * 컬럼 도메인입니다.
     */
    @Column(name = "COLUMN_DOMAIN", length = 200)
    private String domain;

    /**
     * 컬럼 암호화 타입입니다.
     */
    @Column(name = "COLUMN_ENCODE_TYPE", length = 200)
    private String encodeType;

    /**
     * 컬럼 암호화 등급입니다.
     */
    @Column(name = "COLUMN_ENCODE_GRADE")
    private Integer encodeGrade;

    /**
     * 컬럼이 사용하는 코드 그룹 ID입니다.
     */
    @Column(name = "USE_CODE_GROUP_ID", length = 50)
    private String useCodeGroupId;

    // 보고서용 컬럼 start
    /**
     * 컬럼 정보 형태 코드입니다.
     */
    @Nationalized
    @Column(name = "INFORMATION_TYPE", length = 10)
    private String informationType;

    /**
     * 컬럼의 개인정보 유형 코드입니다.
     */
    @Nationalized
    @Column(name = "PERSONAL_INFORMATION_TYPE", length = 10)
    private String personalInformationType;

    /**
     * 컬럼(항목) 설명입니다.<br>
     * 규칙 및 파라미터 설정 후 생성되는 설명 데이터가 저장됩니다.
     */
    @Nationalized
    @Column(name = "COLUMN_EXPLANATION", length = 500)
    private String explanation;

    /**
     * 컬럼 분포 현황 작성 여부입니다.
     */
    @Column(name = "DISTRIBUTION_WRITE_YN")
    private boolean distributionWriteYn;

    /**
     * 컬럼 비고(데이터 출처)입니다.
     */
    @Nationalized
    @Column(name = "COLUMN_REMARK", length = 500)
    private String remark;

    /**
     * 컬럼 가명화 미적용 사유입니다.
     */
    @Nationalized
    @Column(name = "NON_APPLY_REASON", length = 500)
    private String nonApplyReason;

    /**
     * 컬럼 제출 데이터 예시입니다.
     */
    @Nationalized
    @Column(name = "DATA_EXAMPLE", length = 4000)
    private String dataExample;

    /**
     * 컬럼 MAX 값입니다.
     */
    @Nationalized
    @Column(name = "MAX_VALUE", length = 4000)
    private String maxValue;

    /**
     * 컬럼 MAX 값 빈도수입니다.
     */
    @Column(name = "MAX_FREQUENCY")
    private Integer maxFrequency;
    // 보고서용 컬럼 end

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
