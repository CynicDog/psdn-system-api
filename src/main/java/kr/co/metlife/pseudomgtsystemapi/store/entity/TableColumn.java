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
@Table(name = "PSEUDO_TABLE_COLUMN")
public class TableColumn {

    @Id @UuidGenerator
    @Column(name = "PSEUDO_TABLE_COLUMN_ID", nullable = false)
    private UUID uuid;

    @Column(name = "PSEUDO_TABLE_ID", nullable = false)
    private UUID tableId;

    @Column(name = "COLUMN_NAME", nullable = false)
    private String name;

    @Column(name = "COLUMN_LOGICAL_NAME", nullable = false)
    private String logicalName;

    @Column(name = "COLUMN_DATA_TYPE", nullable = false)
    private String dataType;

    @Column(name = "COLUMN_DOMAIN")
    private String domain;

    @Column(name = "COLUMN_ENCODE_TYPE")
    private String encodeType;

    @Column(name = "COLUMN_ENCODE_GRADE")
    private Integer encodeGrade;

    @Column(name = "USE_CODE_GROUP_ID")
    private String useCodeGroupId;
}
