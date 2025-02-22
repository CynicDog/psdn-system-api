package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.JOINED)
@jakarta.persistence.Table(name = "PSEUDO_RULE")
public class Rule {

    @Column(name = "PSEUDO_RULE_ID", nullable = false)
    private UUID uuid;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RULE_ID")
    private Long id;

    @Column(name = "RULE_ATTRIBUTE_NAME", nullable = false)
    private String attributeName;

    @Column(name = "RULE_KOREAN_NAME", nullable = false)
    private String nameKorean;

    @Column(name = "RULE_ENGLISH_NAME", nullable = false)
    private String nameEnglish;

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

    public Rule() {
    }

    public Rule(String attributeName, String nameKorean, String nameEnglish, String explanation) {
        setUuid(UUID.randomUUID());
        this.attributeName = attributeName;
        this.nameKorean = nameKorean;
        this.nameEnglish = nameEnglish;
        this.explanation = explanation;
    }
}
