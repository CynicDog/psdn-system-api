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
 * 프로젝트 Entity를 정의합니다.
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PSEUDO_PROJECT")
public class Project {

    @Id
    @GeneratedValue(generator = "custom-uuid")
    @GenericGenerator(name = "custom-uuid", strategy = "kr.co.metlife.pseudomgtsystemapi.store.util.CustomUUIDGenerator")
    @Column(name = "PSEUDO_PROJECT_ID", nullable = false, length = 32)
    private String id;

    /**
     * 프로젝트명입니다.
     */
    @Nationalized
    @Column(name = "PROJECT_NAME", nullable = false)
    private String name;

    /**
     * 프로젝트 생성 사용자명입니다.
     */
    @Column(name = "PROJECT_USERNAME", nullable = false, length = 120)
    private String username;

    /**
     * 프로젝트 정렬 순서입니다.
     */
    @Column(name = "PROJECT_SEQUENCE")
    private Integer sequence;

    /**
     * 프로젝트 상태입니다.
     */
    @Column(name = "PROJECT_STATUS", nullable = false, length = 20)
    private String status;

    /**
     * 프로젝트 설명입니다.
     */
    @Nationalized
    @Column(name = "PROJECT_EXPLANATION")
    private String explanation;

    /**
     * 프로젝트 승인 일시입니다.
     */
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "APPROVE_TIMESTAMP", columnDefinition = "DATETIME2(3)")
    private LocalDateTime approveTimestamp;

    /**
     * 프로젝트 시작 일시입니다.
     */
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "START_TIMESTAMP", columnDefinition = "DATETIME2(3)")
    private LocalDateTime startTimestamp;

    /**
     * 프로젝트 종료 일시입니다.
     */
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "FINISH_TIMESTAMP", columnDefinition = "DATETIME2(3)")
    private LocalDateTime finishTimestamp;


    /**
     * 프로젝트 생성 사용자명입니다.
     */
    @Column(name = "INPUT_USERNAME", nullable = false, length = 120)
    private String inputUsername;

    /**
     * 프로젝트 생성 일시입니다.
     */
    @CreationTimestamp
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "CREATE_TIMESTAMP", columnDefinition = "DATETIME2(3)")
    private LocalDateTime createTimestamp;

    /**
     * 프로젝트 수정 사용자명입니다.
     */
    @Column(name = "UPDATE_USERNAME", length = 120)
    private String updateUsername;

    /**
     * 프로젝트 수정 일시입니다.
     */
    @UpdateTimestamp
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "UPDATE_TIMESTAMP", columnDefinition = "DATETIME2(3)")
    private LocalDateTime updateTimestamp;

    public static enum Status {
        WRITING,
        PENDING,
        APPROVED,
        FINISHED,
    }
}
