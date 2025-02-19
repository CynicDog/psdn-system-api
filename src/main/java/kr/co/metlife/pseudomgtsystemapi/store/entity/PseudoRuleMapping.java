package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "PSEUDO_RULE_MAPPING", schema = "pseudo")
public class PseudoRuleMapping {
    @Id
    @Column(name = "PSEUDO_RULE_MAPPING_ID", nullable = false, length = 32)
    private String pseudoRuleMappingId;

    @Column(name = "PSEUDO_ID", nullable = false)
    private Long pseudoId;

    @Column(name = "MAPPING_ID", nullable = false)
    private Long mappingId;

    @Column(name = "TARGET_COLUMN_ID", nullable = false)
    private Long targetColumnId;

    @Column(name = "RULE_ID", nullable = false, length = 50)
    private String ruleId;

    @Column(name = "APPLY_SEQUENCE", columnDefinition = "tinyint not null")
    private Short applySequence;

    @Column(name = "INPUT_USER_CODE", nullable = false, length = 8)
    private String inputUserCode;

    @Column(name = "INPUT_TIMESTAMP", nullable = false)
    private Instant inputTimestamp;

    @Column(name = "UPDATE_USER_CODE", nullable = false, length = 8)
    private String updateUserCode;

    @Column(name = "UPDATE_TIMESTAMP", nullable = false)
    private Instant updateTimestamp;

}