package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
@AllArgsConstructor
@Table(name = "PSEUDO_CONFIG_TABLE_COLUMN")
public class ConfigTableColumn  {

    @Column(name = "PSEUDO_CONFIG_TABLE_COLUMN_ID", nullable = false)
    private UUID uuid;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONFIG_TABLE_COLUMN_ID")
    private Long id;

    @Column(name = "CONFIG_TABLE_COLUMN_NAME", nullable = false)
    private String name;

    @Column(name = "CONFIG_TABLE_COLUMN_LOGICAL_NAME", nullable = false)
    private String logicalName;

    @Column(name = "CONFIG_TABLE_COLUMN_DATA_TYPE", nullable = false)
    private String dataType;

    @Column(name = "CONFIG_TABLE_COLUMN_DOMAIN")
    private String domain;

    @Column(name = "CONFIG_TABLE_COLUMN_ENCODE_TYPE")
    private String encodeType;

    @Column(name = "CONFIG_TABLE_COLUMN_ENCODE_GRADE")
    private Integer encodeGrade;

    @Column(name = "USE_CODE_GROUP_ID")
    private String useCodeGroupId;

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
    @JoinColumn(name = "PSEUDO_CONFIG_TABLE_ID", nullable = false)
    private ConfigTable configTable;

    @OneToMany(mappedBy = "configTableColumn", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConfigRule> rules;

    public ConfigTableColumn() {
        setUuid(UUID.randomUUID());
    }
}
