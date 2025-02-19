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
@Table(name = "PSEUDO_RULE", schema = "pseudo")
public class PseudoRule {
    @Id
    @Column(name = "PSEUDO_RULE_ID", nullable = false, length = 32)
    private String pseudoRuleId;

    @Column(name = "RULE_ID", nullable = false, length = 50)
    private String ruleId;

    @Column(name = "RULE_ATTRIBUTE_NAME", nullable = false, length = 50)
    private String ruleAttributeName;

    @Nationalized
    @Column(name = "RULE_KOREAN_NAME", nullable = false, length = 50)
    private String ruleKoreanName;

    @Column(name = "RULE_ENGLISH_NAME", nullable = false, length = 50)
    private String ruleEnglishName;

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