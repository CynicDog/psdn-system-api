package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import kr.co.metlife.pseudomgtsystemapi.store.util.ParameterValueConverter;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@jakarta.persistence.Table(name = "PSEUDO_PARAMETER")
public class Parameter {

    @Id @UuidGenerator
    @Column(name = "PSEUDO_PARAMETER_ID", nullable = false)
    private UUID id;

    @Column(name = "PARAMETER_ATTRIBUTE_NAME")
    private String attributeName;

    @Column(name = "PARAMETER_KOREAN_NAME")
    private String nameKorean;

    @Column(name = "PARAMETER_ENGLISH_NAME")
    private String nameEnglish;

    @Column(name = "PARAMETER_TYPE")
    private String type;

    @Convert(converter = ParameterValueConverter.class)
    @Column(name = "PARAMETER_DEFAULT_VALUE")
    private Object defaultValue;

    @Column(name = "EXPLANATION")
    private String explanation;

    public Parameter() {
    }

    public Parameter(String attributeName, String nameKorean, String nameEnglish, String type, Object defaultValue, String explanation) {
        this.attributeName = attributeName;
        this.nameKorean = nameKorean;
        this.nameEnglish = nameEnglish;
        this.type = type;
        this.defaultValue = defaultValue;
        this.explanation = explanation;
    }
}
