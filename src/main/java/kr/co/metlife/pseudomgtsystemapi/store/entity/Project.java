package kr.co.metlife.pseudomgtsystemapi.store.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Getter @Setter
@Table(name = "PSEUDO_PROJECT")
public class Project {

    @Column(name = "PSEUDO_PROJECT_ID", nullable = false)
    private String uuid;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_ID")
    private Long id;

    @Column(name = "PROJECT_NAME", nullable = false)
    private String name;

    @Column(name = "PROJECT_SEQUENCE", nullable = false)
    private Integer sequence;

    @Column(name = "PROJECT_EXPLANATION")
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

    // TODO: Bidirectional Eager Fetch && JsonIgnore => Lazy Fetch
    @ManyToOne @JsonIgnore
    @JoinColumn(name = "PSEUDO_USER_ID", nullable = false)
    private User user;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConfigTable> configTables = new ArrayList<>();

    public Project() {
    }

    public Project(String name, Integer sequence, String explanation, User user) {
        setUuid(UUID.randomUUID().toString());
        this.name = name;
        this.sequence = sequence;
        this.explanation = explanation;
        this.user = user;
    }

    public void addConfigTable(kr.co.metlife.pseudomgtsystemapi.store.entity.Table table, List<TableColumn> columns) {

        ConfigTable configTable = new ConfigTable(table.getName(), table.getLogicalName());
        configTable.setProject(this);

        // TableColumn -> ConfigTableColumn 형변환
        List<ConfigTableColumn> configTableColumns = columns.stream()
                .map(column -> new ConfigTableColumn(column.getName(), column.getLogicalName(), column.getDataType(), configTable))
                .collect(Collectors.toList());

        configTable.addColumns(configTableColumns);

        if (this.configTables == null) {
            this.configTables = new ArrayList<>();
        }
        this.configTables.add(configTable);
    }

}
