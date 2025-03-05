package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import kr.co.metlife.pseudomgtsystemapi.store.util.StringToLocalDateTimeConverter;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PSEUDO_RULE")
public class Rule {

    @Id
    @GeneratedValue(generator = "custom-uuid")
    @GenericGenerator(name = "custom-uuid", strategy = "kr.co.metlife.pseudomgtsystemapi.store.util.CustomUUIDGenerator")
    @Column(name = "PSEUDO_RULE_ID", nullable = false, length = 32)
    private String id;

    @Column(name = "RULE_ATTRIBUTE_NAME", nullable = false, length = 50)
    private String attributeName;

    @Column(name = "RULE_KOREAN_NAME", nullable = false, length = 50)
    private String nameKorean;

    @Column(name = "RULE_ENGLISH_NAME", nullable = false, length = 50)
    private String nameEnglish;

    @Column(name = "SEQUENCE")
    private Integer sequence;

    @Column(name = "RULE_EXPLANATION")
    private String explanation;

    @Column(name = "INPUT_USER_ID", nullable = false, length = 120)
    private String inputUserId;

    @CreationTimestamp
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "INPUT_TIMESTAMP", nullable = true, columnDefinition = "DATETIME2(3)")
    private LocalDateTime inputTimestamp;

    @Column(name = "UPDATE_USER_ID", nullable = true, length = 120)
    private String updateUserId;

    @UpdateTimestamp
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "UPDATE_TIMESTAMP", nullable = true, columnDefinition = "DATETIME2(3)")
    private LocalDateTime updateTimestamp;

    public Rule(String attributeName, String nameKorean, String nameEnglish, Integer sequence, String explanation, String inputUserId) {
        this.attributeName = attributeName;
        this.nameKorean = nameKorean;
        this.nameEnglish = nameEnglish;
        this.sequence = sequence;
        this.explanation = explanation;
        this.inputUserId = inputUserId;
    }
}
