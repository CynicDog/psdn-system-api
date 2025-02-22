package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import kr.co.metlife.pseudomgtsystemapi.store.util.ParameterValueConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.JOINED)
@jakarta.persistence.Table(name = "PSEUDO_PARAMETER")
public class Parameter {

    @Column(name = "PSEUDO_PARAMETER_ID", nullable = false)
    private UUID uuid;

    @Column(name = "PARAMETER_ID")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PARAMETER_ATTRIBUTE_NAME", nullable = false)
    private String attributeName;

    @Column(name = "PARAMETER_KOREAN_NAME", nullable = false)
    private String nameKorean;

    @Column(name = "PARAMETER_ENGLISH_NAME", nullable = false)
    private String nameEnglish;

    @Column(name = "PARAMETER_TYPE", nullable = false)
    private String type;

    @Convert(converter = ParameterValueConverter.class)
    @Column(name = "PARAMETER_VALUE", nullable = false)
    private Object value;

    @Column(name = "EXPLANATION")
    private String explanation;

    @Column(name = "INPUT_USER_CODE")
    private String inputUserCode;

    @CreationTimestamp
    @Column(name = "INPUT_TIMESTAMP")
    private LocalDateTime inputTimestamp;

    @Column(name = "UPDATE_USER_CODE")
    private String updateUserCode;

    @UpdateTimestamp
    @Column(name = "UPDATE_TIMESTAMP")
    private LocalDateTime updateTimestamp;

    public Parameter() {
    }

    public Parameter(String attributeName, String nameKorean, String nameEnglish, String type, Object value, String explanation) {
        setUuid(UUID.randomUUID());
        this.attributeName = attributeName;
        this.nameKorean = nameKorean;
        this.nameEnglish = nameEnglish;
        this.type = type;
        this.value = value;
        this.explanation = explanation;
    }
}
