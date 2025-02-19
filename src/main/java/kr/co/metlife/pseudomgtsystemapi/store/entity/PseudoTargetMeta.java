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
@Table(name = "PSEUDO_TARGET_META", schema = "pseudo")
public class PseudoTargetMeta {
    @Id
    @Column(name = "PSEUDO_TARGET_META_ID", nullable = false, length = 32)
    private String pseudoTargetMetaId;

    @Column(name = "PROJECT_ID", nullable = false)
    private Long projectId;

    @Column(name = "PSEUDO_ID", nullable = false)
    private Long pseudoId;

    @Column(name = "TARGET_COLUMN_ID", nullable = false)
    private Long targetColumnId;

    @Column(name = "APPLY_YN", nullable = false)
    private Boolean applyYn = false;

    @Column(name = "INTYPEATION_TYPE", length = 50)
    private String intypeationType;

    @Nationalized
    @Column(name = "EXPLANATION", length = 1000)
    private String explanation;

    @Column(name = "DISTRIBUTION_WRITE_YN")
    private Boolean distributionWriteYn;

    @Nationalized
    @Column(name = "REMARK", length = 1000)
    private String remark;

    @Nationalized
    @Column(name = "NON_APPLY_REASON", length = 1000)
    private String nonApplyReason;

    @Nationalized
    @Column(name = "DATA_EXEMPLIFICATION", length = 4000)
    private String dataExemplification;

    @Nationalized
    @Column(name = "MAX_VALUE", length = 4000)
    private String maxValue;

    @Column(name = "MAX_FREQUENCY")
    private Long maxFrequency;

    @Column(name = "INPUT_USER_CODE", nullable = false, length = 8)
    private String inputUserCode;

    @Column(name = "INPUT_TIMESTAMP", nullable = false)
    private Instant inputTimestamp;

    @Column(name = "UPDATE_USER_CODE", nullable = false, length = 8)
    private String updateUserCode;

    @Column(name = "UPDATE_TIMESTAMP", nullable = false)
    private Instant updateTimestamp;

}