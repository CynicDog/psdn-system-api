package kr.co.metlife.pseudomgtsystemapi.store.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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

    @ManyToOne @JsonIgnore
    @JoinColumn(name = "PSEUDO_PROJECT_ID", nullable = false)
    private Project project;

    public ConfigTable() {
    }

    public ConfigTable(String name, String logicalName) {
        setUuid(UUID.randomUUID().toString());
        this.name = name;
        this.logicalName = logicalName;
    }

    public void addColumn(ConfigTableColumn column) {
        if (this.configColumns == null) {
            this.configColumns = new ArrayList<>();
        }
        this.configColumns.add(column);
    }

    public void addColumns(List<ConfigTableColumn> columns) {
        if (this.configColumns == null) {
            this.configColumns = new ArrayList<>();
        }
        columns.forEach(this::addColumn);
    }
}
