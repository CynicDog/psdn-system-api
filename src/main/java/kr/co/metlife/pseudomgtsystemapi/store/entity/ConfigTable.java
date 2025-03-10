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
 * 가명화 작업 구성 테이블 Entity를 정의합니다.
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PSEUDO_CONFIG_TABLE")
public class ConfigTable {

    @Id
    @GeneratedValue(generator = "custom-uuid")
    @GenericGenerator(name = "custom-uuid", strategy = "kr.co.metlife.pseudomgtsystemapi.store.util.CustomUUIDGenerator")
    @Column(name = "PSEUDO_CONFIG_TABLE_ID", nullable = false, length = 32)
    private String id;

    /**
     * 가명화 프로젝트 ID입니다.
     */
    @Column(name = "PSEUDO_PROJECT_ID", nullable = false, length = 32)
    private String projectId;

    /**
     * 테이블 메타 ID입니다.
     */
    @Column(name = "PSEUDO_TABLE_ID", nullable = true, length = 32) // comment: 프로젝트 작성 중이나 아직 원본 테이블 지정 안했을 수 있음.
    private String tableId;

    /**
     * 테이블명입니다.
     */
    @Column(name = "TABLE_NAME", nullable = true, length = 200) // comment: 프로젝트 작성 중이나 아직 원본 테이블 지정 안했을 수 있음.
    private String name;

    /**
     * 테이블 논리명입니다.
     */
    @Nationalized
    @Column(name = "TABLE_LOGICAL_NAME", length = 400)
    private String logicalName;

    /**
     * 테이블 설명입니다.
     */
    @Nationalized
    @Column(name = "TABLE_EXPLANATION")
    private String explanation;

    /**
     * 가명화 회차입니다.<br>
     * 프로젝트-테이블 별로 회차가 증가합니다.
     */
    @Column(name = "ITERATION", nullable = false)
    private Integer iteration;

    /**
     * 테이블 조회 순서입니다.
     */
    @Column(name = "TABLE_SEQUENCE")
    private Integer sequence;

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
    @Column(name = "INPUT_TIMESTAMP", columnDefinition = "DATETIME2(3)")
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
