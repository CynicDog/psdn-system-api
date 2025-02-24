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
    private UUID uuid;

    @Column(name = "PSEUDO_PROJECT_ID", nullable = false)
    private UUID projectId;

    @Column(name = "CONFIG_TABLE_ITERATION")
    private Integer iteration;

    @Column(name = "CONFIG_TABLE_NAME", nullable = false)
    private String name;

    @Column(name = "CONFIG_TABLE_LOGICAL_NAME", nullable = false)
    private String logicalName;
}
