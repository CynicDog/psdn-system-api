package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@jakarta.persistence.Table(name = "PSEUDO_CONFIG_TABLE")
public class ConfigTable {

    @Id @UuidGenerator
    @Column(name = "PSEUDO_CONFIG_TABLE_ID", nullable = false)
    private UUID id;

    @Column(name = "PSEUDO_PROJECT_ID", nullable = false)
    private UUID projectId;

    @Column(name = "PSEUDO_TABLE_ID", nullable = false)
    private UUID tableId;

    @Column(name = "CONFIG_TABLE_NAME")
    private String name;

    @Column(name = "CONFIG_TABLE_LOGICAL_NAME")
    private String logicalName;

    @Column(name = "CONFIG_TABLE_ITERATION")
    private Integer iteration;

    @Column(name = "CONFIG_TABLE_ORDER")
    private Integer order;

    public ConfigTable() {
    }

    public ConfigTable(UUID projectId, UUID tableId, String name, String logicalName, Integer iteration, Integer order) {
        this.projectId = projectId;
        this.tableId = tableId;
        this.name = name;
        this.logicalName = logicalName;
        this.iteration = iteration;
        this.order = order;
    }
}
