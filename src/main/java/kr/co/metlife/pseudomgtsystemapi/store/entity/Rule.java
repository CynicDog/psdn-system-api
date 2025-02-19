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
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@jakarta.persistence.Table(name = "PSEUDO_RULE")
public class Rule {

    @Id @UuidGenerator
    @Column(name = "PSEUDO_RULE_ID")
    private UUID uuid;

    @Column(name = "RULE_ID", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "RULE_ATTRIBUTE_NAME", nullable = false)
    private String attributeName;

    @Column(name = "RULE_KOREAN_NAME", nullable = false)
    private String nameKorean;

    @Column(name = "RULE_ENGLISH_NAME", nullable = false)
    private String nameEnglish;

    @Column(name = "EXPLANATION")
    private String explanation;

    @CreationTimestamp
    @Column(name = "INPUT_USER_CODE")
    private String inputUserCode;

    @Column(name = "INPUT_TIMESTAMP")
    private LocalDateTime inputTimestamp;

    @UpdateTimestamp
    @Column(name = "UPDATE_USER_CODE")
    private String updateUserCode;

    @Column(name = "UPDATE_TIMESTAMP")
    private LocalDateTime updateTimestamp;

    @ManyToMany(mappedBy = "rules", fetch = FetchType.LAZY)
    private Set<TableColumn> columns;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "PSEUDO_RULE_PARAMETER",
            joinColumns = @JoinColumn(name = "PSEUDO_RULE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PSEUDO_PARAMETER_ID")
    )
    private List<Parameter> parameters;
}
