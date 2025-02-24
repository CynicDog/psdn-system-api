package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import kr.co.metlife.pseudomgtsystemapi.store.util.ParameterValueConverter;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "PSEUDO_CONFIG_PARAMETER")
public class ConfigParameter {

    @Id
    @UuidGenerator
    @Column(name = "PSEUDO_CONFIG_PARAMETER_ID", nullable = false)
    private UUID id;

    @Column(name = "PSEUDO_PARAMETER_ID", nullable = false)
    private UUID parameterId;

    @Column(name = "PSEUDO_CONFIG_TABLE_ID", nullable = false)
    private UUID configTableId;

    @Column(name = "CONFIG_TABLE_ITERATION")
    private Integer configTableIteration;

    @Column(name = "PSEUDO_CONFIG_TABLE_COLUMN_ID", nullable = false)
    private UUID configTableColumnId;

    @Column(name = "PSEUDO_CONFIG_RULE_ID", nullable = false)
    private UUID configRuleId;

    @Column(name = "CONFIG_PARAMETER_ATTRIBUTE_NAME")
    private String attributeName;

    @Column(name = "CONFIG_PARAMETER_KOREAN_NAME")
    private String nameKorean;

    @Column(name = "CONFIG_PARAMETER_ENGLISH_NAME")
    private String nameEnglish;

    @Column(name = "CONFIG_PARAMETER_TYPE")
    private String type;

    @Column(name = "CONFIG_PARAMETER_VALUE")
    @Convert(converter = ParameterValueConverter.class)
    private Object value;

    public ConfigParameter() {
    }

    public ConfigParameter(UUID configTableId, Integer configTableIteration, UUID configTableColumnId, UUID configRuleId, Object value, UUID parameterId) {
        this.configTableId = configTableId;
        this.configTableIteration = configTableIteration;
        this.configTableColumnId = configTableColumnId;
        this.configRuleId = configRuleId;
        this.value = value;
        this.parameterId = parameterId;
    }
}
