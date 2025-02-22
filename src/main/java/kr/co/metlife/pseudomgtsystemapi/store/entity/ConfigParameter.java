package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
@AllArgsConstructor
@Table(name = "PSEUDO_CONFIG_PARAMETER")
public class ConfigParameter {

    @Column(name = "PSEUDO_CONFIG_PARAMETER_ID", nullable = false)
    private UUID uuid;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONFIG_PARAMETER_ID")
    private Long id;

    @Column(name = "CONFIG_PARAMETER_ATTRIBUTE_NAME", nullable = false)
    private String attributeName;

    @Column(name = "CONFIG_PARAMETER_KOREAN_NAME", nullable = false)
    private String nameKorean;

    @Column(name = "CONFIG_PARAMETER_ENGLISH_NAME", nullable = false)
    private String nameEnglish;

    @Column(name = "CONFIG_PARAMETER_TYPE", nullable = false)
    private String type;

    @Column(name = "CONFIG_PARAMETER_VALUE", nullable = true)
    private String value;

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

    @ManyToOne
    @JoinColumn(name = "PSEUDO_CONFIG_RULE_ID", nullable = false)
    private ConfigRule configRule;

    public ConfigParameter() {
        setUuid(UUID.randomUUID());
    }
}
