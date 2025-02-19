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
@Table(name = "PSEUDO_RULE_PARAMETER_VALUE", schema = "pseudo")
public class PseudoRuleParameterValue {
    @Id
    @Column(name = "PSEUDO_RULE_PARAMETER_VALUE_ID", nullable = false, length = 32)
    private String pseudoRuleParameterValueId;

    @Column(name = "MAPPING_ID", nullable = false)
    private Long mappingId;

    @Column(name = "PARAMETER_ID", nullable = false, length = 50)
    private String parameterId;

    @Nationalized
    @Column(name = "PARAMETER_VALUE")
    private String parameterValue;

    @Column(name = "INPUT_USER_CODE", nullable = false, length = 8)
    private String inputUserCode;

    @Column(name = "INPUT_TIMESTAMP", nullable = false)
    private Instant inputTimestamp;

    @Column(name = "UPDATE_USER_CODE", nullable = false, length = 8)
    private String updateUserCode;

    @Column(name = "UPDATE_TIMESTAMP", nullable = false)
    private Instant updateTimestamp;

}