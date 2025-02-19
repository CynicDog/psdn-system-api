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
@Table(name = "PSEUDO_RULE_PARAMETER", schema = "pseudo")
public class PseudoRuleParameter {
    @Id
    @Column(name = "PSEUDO_RULE_PARAMETER_ID", nullable = false, length = 32)
    private String pseudoRuleParameterId;

    @Column(name = "PARAMETER_ID", nullable = false, length = 50)
    private String parameterId;

    @Column(name = "PARAMETER_ATTRIBUTE_NAME", nullable = false, length = 50)
    private String parameterAttributeName;

    @Nationalized
    @Column(name = "PARAMETER_KOREAN_NAME", nullable = false, length = 50)
    private String parameterKoreanName;

    @Column(name = "PARAMETER_ENGLISH_NAME", nullable = false, length = 50)
    private String parameterEnglishName;

    @Column(name = "PARAMETER_TYPE", nullable = false, length = 50)
    private String parameterType;

    @Nationalized
    @Column(name = "DEFAULT_VALUE")
    private String defaultValue;

    @Nationalized
    @Column(name = "EXPLANATION", length = 1000)
    private String explanation;

    @Column(name = "INPUT_USER_CODE", nullable = false, length = 8)
    private String inputUserCode;

    @Column(name = "INPUT_TIMESTAMP", nullable = false)
    private Instant inputTimestamp;

    @Column(name = "UPDATE_USER_CODE", nullable = false, length = 8)
    private String updateUserCode;

    @Column(name = "UPDATE_TIMESTAMP", nullable = false)
    private Instant updateTimestamp;

}