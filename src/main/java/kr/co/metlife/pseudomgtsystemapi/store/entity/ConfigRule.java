package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "PSEUDO_CONFIG_RULE")
public class ConfigRule {

    @Id @UuidGenerator
    @Column(name = "PSEUDO_CONFIG_RULE_ID", nullable = false)
    private UUID id;

    @Column(name = "PSEUDO_RULE_ID", nullable = false)
    private UUID ruleId;

    @Column(name = "PSEUDO_CONFIG_TABLE_ID", nullable = false)
    private UUID configTableId;

    @Column(name = "CONFIG_TABLE_ITERATION")
    private Integer configTableIteration;

    @Column(name = "PSEUDO_CONFIG_TABLE_COLUMN_ID", nullable = false)
    private UUID configTableColumnId;

    @Column(name = "RULE_ATTRIBUTE_NAME")
    private String attributeName;

    @Column(name = "RULE_KOREAN_NAME")
    private String nameKorean;

    @Column(name = "RULE_ENGLISH_NAME")
    private String nameEnglish;

    @Column(name = "EXPLANATION")
    private String explanation;

    @Column(name = "RULE_SEQUENCE")
    private Integer sequence;

    public ConfigRule() {
    }

    public ConfigRule(UUID configTableId, Integer configTableIteration, UUID configTableColumnId, Integer sequence, UUID ruleId) {
        this.configTableId = configTableId;
        this.configTableIteration = configTableIteration;
        this.configTableColumnId = configTableColumnId;
        this.sequence = sequence;
        this.ruleId = ruleId;
    }
}
