package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import kr.co.metlife.pseudomgtsystemapi.store.util.StringToLocalDateTimeConverter;
import lombok.*;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;

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

    @Column(name = "OWNER_ID", nullable = false, length = 120)
    private String userId;

    @Column(name = "PROJECT_NAME", nullable = false)
    private String name;

    @Column(name = "PROJECT_SEQUENCE")
    private Integer sequence;

    @Column(name = "PROJECT_STATUS", nullable = false, length = 20)
    private String status;

    @Column(name = "PROJECT_EXPLANATION")
    private String explanation;

    @Column(name = "INPUT_USER_ID", nullable = false, length = 120)
    private String inputUserId;

    @CreationTimestamp
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "CREATE_TIMESTAMP", nullable = true, columnDefinition = "DATETIME2(3)")
    private LocalDateTime createTimestamp;

    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "APPROVE_TIMESTAMP", nullable = true, columnDefinition = "DATETIME2(3)")
    private LocalDateTime approveTimestamp;

    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "START_TIMESTAMP", nullable = true, columnDefinition = "DATETIME2(3)")
    private LocalDateTime startTimestamp;

    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "FINISH_TIMESTAMP", nullable = true, columnDefinition = "DATETIME2(3)")
    private LocalDateTime finishTimestamp;

    @Column(name = "UPDATE_USER_ID", nullable = true, length = 120)
    private String updateUserId;

    @UpdateTimestamp
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "UPDATE_TIMESTAMP", nullable = true, columnDefinition = "DATETIME2(3)")
    private LocalDateTime updateTimestamp;

    public Project(String userId, String name, Integer sequence, String status, String explanation, String inputUserId, LocalDateTime approveTimestamp, LocalDateTime startTimestamp, LocalDateTime finishTimestamp) {
        this.userId = userId;
        this.name = name;
        this.sequence = sequence;
        this.status = status;
        this.explanation = explanation;
        this.inputUserId = inputUserId;
        this.approveTimestamp = approveTimestamp;
        this.startTimestamp = startTimestamp;
        this.finishTimestamp = finishTimestamp;
    }

    public static enum Status {
        WRITING,
        PENDING,
        APPROVED,
        FINISHED,
    }
}
