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
 * 재식별 이력 Entity를 정의합니다.
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RE_IDENTIFICATION_HISTORY")
public class ReIdentificationHistory {

    @Id
    @GeneratedValue(generator = "custom-uuid")
    @GenericGenerator(name = "custom-uuid", strategy = "kr.co.metlife.pseudomgtsystemapi.store.util.CustomUUIDGenerator")
    @Column(name = "RE_IDENTIFICATION_HISTORY_ID", nullable = false, length = 32)
    private String id;

    /**
     * 가명화 작업 구성 테이블 ID입니다.
     */
    @Column(name = "PSEUDO_CONFIG_TABLE_ID", nullable = false, length = 32)
    private String configTableId;

    /**
     * 재식별 키 파일명입니다.
     */
    @Column(name = "KEY_FILE_NAME", nullable = false)
    private String keyFileName;

    /**
     * 재식별 처리 시작 일시입니다.
     */
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "START_TIMESTAMP", nullable = false, columnDefinition = "DATETIME2(3)")
    private LocalDateTime startTimestamp;

    /**
     * 재식별 처리 종료 일시입니다.
     */
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "END_TIMESTAMP", nullable = false, columnDefinition = "DATETIME2(3)")
    private LocalDateTime endTimestamp;

    /**
     * 재식별 성공 여부입니다.
     */
    @Column(name = "SUCCESS_YN", nullable = false)
    private Boolean successYn;

    /**
     * 재식별 실패 원인입니다.
     */
    @Nationalized
    @Column(name = "FAIL_CAUSE", nullable = false, length = 1000)
    private Boolean failCause;
}
