package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "PSEUDO_CONFIG_TABLE_COLUMN")
public class ConfigTableColumn  {

    @Id @UuidGenerator
    @Column(name = "PSEUDO_CONFIG_TABLE_COLUMN_ID", nullable = false)
    private UUID id;

    @Column(name = "PSEUDO_CONFIG_TABLE_ID", nullable = false)
    private UUID configTableId;

    @Column(name = "PSEUDO_TABLE_COLUMN_ID", nullable = false)
    private UUID columnId;

    @Column(name = "CONFIG_TABLE_ITERATION")
    private Integer configTableIteration;

    @Column(name = "CONFIG_TABLE_COLUMN_NAME")
    private String name;

    @Column(name = "CONFIG_TABLE_COLUMN_LOGICAL_NAME")
    private String logicalName;

    @Column(name = "CONFIG_TABLE_COLUMN_DATA_TYPE")
    private String dataType;

    @Column(name = "CONFIG_TABLE_COLUMN_DOMAIN")
    private String domain;

    @Column(name = "CONFIG_TABLE_COLUMN_ENCODE_TYPE")
    private String encodeType;

    @Column(name = "CONFIG_TABLE_COLUMN_ENCODE_GRADE")
    private Integer encodeGrade;

    @Column(name = "USE_CODE_GROUP_ID")
    private String useCodeGroupId;

    public ConfigTableColumn() {
    }

    public ConfigTableColumn(UUID configTableId, Integer configTableIteration, UUID columnId, String name, String logicalName, String dataType) {
        this.configTableId = configTableId;
        this.configTableIteration = configTableIteration;
        this.columnId = columnId;
        this.name = name;
        this.logicalName = logicalName;
        this.dataType = dataType;
    }
}
