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
@Table(name = "RE_IDENTIFICATION_REQUEST_HISTORY", schema = "pseudo")
public class ReIdentificationRequestHistory {
    @Id
    @Column(name = "RE_IDENTIFICATION_REQUEST_HISTORY_ID", nullable = false, length = 32)
    private String reIdentificationRequestHistoryId;

    @Column(name = "PSEUDO_ID", nullable = false)
    private Long pseudoId;

    @Column(name = "RE_IDENTIFICATION_ID", nullable = false)
    private Long reIdentificationId;

    @Column(name = "KEY_FILE_NAME", nullable = false, length = 100)
    private String keyFileName;

    @Column(name = "REQUESTOR_CODE", nullable = false, length = 8)
    private String requestorCode;

    @Column(name = "START_TIMESTAMP", nullable = false)
    private Instant startTimestamp;

    @Column(name = "END_TIMESTAMP", nullable = false)
    private Instant endTimestamp;

    @Column(name = "SUCCESS_YN", nullable = false)
    private Boolean successYn = false;

    @Nationalized
    @Column(name = "FAIL_CAUSE", length = 1000)
    private String failCause;

}