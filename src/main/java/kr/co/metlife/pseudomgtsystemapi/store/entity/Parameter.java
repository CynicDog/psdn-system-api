package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import kr.co.metlife.pseudomgtsystemapi.store.util.ParameterValueConverter;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.JOINED)
@jakarta.persistence.Table(name = "PSEUDO_PARAMETER")
public class Parameter {

    @Id @UuidGenerator
    @Column(name = "PSEUDO_PARAMETER_ID", nullable = false)
    private UUID uuid;

    @Column(name = "PSEUDO_RULE_ID", nullable = false)
    private UUID ruleId;

    @Column(name = "PARAMETER_ATTRIBUTE_NAME", nullable = false)
    private String attributeName;

    @Column(name = "PARAMETER_KOREAN_NAME", nullable = false)
    private String nameKorean;

    @Column(name = "PARAMETER_ENGLISH_NAME", nullable = false)
    private String nameEnglish;

    @Column(name = "PARAMETER_TYPE", nullable = false)
    private String type;

    @Convert(converter = ParameterValueConverter.class)
    @Column(name = "PARAMETER_DEFAULT_VALUE", nullable = false)
    private Object defaultValue;

    @Column(name = "EXPLANATION")
    private String explanation;
}
