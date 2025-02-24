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
    private UUID uuid;

    @Column(name = "PSEUDO_CONFIG_TABLE_ID", nullable = false)
    private UUID configTableId;

    @Column(name = "CONFIG_TABLE_ITERATION")
    private Integer configTableIteration;

    @Column(name = "PSEUDO_CONFIG_TABLE_COLUMN_ID", nullable = false)
    private UUID configTableColumnId;

    @Column(name = "PSEUDO_CONFIG_RULE_ID", nullable = false)
    private UUID configRuleId;

    @Column(name = "CONFIG_PARAMETER_ATTRIBUTE_NAME", nullable = false)
    private String attributeName;

    @Column(name = "CONFIG_PARAMETER_KOREAN_NAME", nullable = false)
    private String nameKorean;

    @Column(name = "CONFIG_PARAMETER_ENGLISH_NAME", nullable = false)
    private String nameEnglish;

    @Column(name = "CONFIG_PARAMETER_TYPE", nullable = false)
    private String type;

    @Column(name = "CONFIG_PARAMETER_VALUE", nullable = true)
    @Convert(converter = ParameterValueConverter.class)
    private Object value;
}
