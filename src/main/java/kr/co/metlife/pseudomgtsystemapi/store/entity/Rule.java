package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@jakarta.persistence.Table(name = "PSEUDO_RULE")
public class Rule {

    @Id @UuidGenerator
    @Column(name = "PSEUDO_RULE_ID", nullable = false)
    private UUID id;

    @Column(name = "RULE_ATTRIBUTE_NAME")
    private String attributeName;

    @Column(name = "RULE_KOREAN_NAME")
    private String nameKorean;

    @Column(name = "RULE_ENGLISH_NAME")
    private String nameEnglish;

    @Column(name = "EXPLANATION")
    private String explanation;

    public Rule() {
    }

    public Rule(String attributeName, String nameKorean, String nameEnglish, String explanation) {
        this.attributeName = attributeName;
        this.nameKorean = nameKorean;
        this.nameEnglish = nameEnglish;
        this.explanation = explanation;
    }
}
