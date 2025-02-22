package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter @Setter
@AllArgsConstructor
@Table(name = "PSEUDO_CONFIG_RULE")
public class ConfigRule {

    @Column(name = "PSEUDO_CONFIG_RULE_ID", nullable = false)
    private String uuid;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONFIG_RULE_ID")
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

//    @CreationTimestamp
    @Column(name = "INPUT_TIMESTAMP")
    private LocalDateTime inputTimestamp;

    @Column(name = "UPDATE_USER_CODE")
    private String updateUserCode;

//    @UpdateTimestamp
    @Column(name = "UPDATE_TIMESTAMP")
    private LocalDateTime updateTimestamp;

    @Column(name = "RULE_ORDER", nullable = false)
    private Integer configRuleOrder;

    @ManyToOne
    @JoinColumn(name = "PSEUDO_CONFIG_TABLE_COLUMN_ID", nullable = false)
    private ConfigTableColumn configTableColumn;

    @OneToMany(mappedBy = "configRule", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<ConfigParameter> configParameters;

    public ConfigRule() {
    }
}
