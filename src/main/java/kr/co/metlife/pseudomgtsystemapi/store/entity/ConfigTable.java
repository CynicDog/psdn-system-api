package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
@AllArgsConstructor
@jakarta.persistence.Table(name = "PSEUDO_CONFIG_TABLE")
public class ConfigTable {

    @Column(name = "PSEUDO_CONFIG_TABLE_ID", nullable = false)
    private String uuid;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONFIG_TABLE_ID")
    private Long id;

    @Column(name = "CONFIG_TABLE_NAME", nullable = false)
    private String name;

    @Column(name = "CONFIG_TABLE_LOGICAL_NAME", nullable = false)
    private String logicalName;

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

    @OneToMany(mappedBy = "configTable", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConfigTableColumn> configColumns = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "PSEUDO_PROJECT_ID", nullable = false)
    private Project project;

    public ConfigTable() {
    }

    public ConfigTable(String name, String logicalName) {
        setUuid(UUID.randomUUID().toString());
        this.name = name;
        this.logicalName = logicalName;
    }
}
