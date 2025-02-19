package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "PSEUDO_PROJECT", schema = "pseudo")
public class PseudoProject {
    @Id
    @Column(name = "PSEUDO_PROJECT_ID", nullable = false, length = 32)
    private String pseudoProjectId;

    @Column(name = "PROJECT_ID", nullable = false)
    private Long projectId;

    @Nationalized
    @Column(name = "PROJECT_NAME", nullable = false, length = 50)
    private String projectName;

    @Column(name = "PROJECT_SEQUENCE", nullable = false)
    private Integer projectSequence;

    @Nationalized
    @Column(name = "EXPLANATION", length = 1000)
    private String explanation;

    @Column(name = "OWNER_CODE", nullable = false, length = 8)
    private String ownerCode;

    @Column(name = "CREATE_TIMESTAMP", nullable = false)
    private Instant createTimestamp;

    @Column(name = "UPDATE_TIMESTAMP", nullable = false)
    private Instant updateTimestamp;

}