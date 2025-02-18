package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PSEUDO_TABLE_COLUMN")
public class TableColumn {

    @Id @UuidGenerator
    @Column(name = "PSEUDO_TABLE_COLUMN_ID")
    private UUID uuid;

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

    @CreationTimestamp
    @Column(name = "INPUT_USER_CODE")
    private String inputUserCode;

    @Column(name = "INPUT_TIMESTAMP")
    private LocalDateTime inputTimestamp;

    @UpdateTimestamp
    @Column(name = "UPDATE_USER_CODE")
    private String updateUserCode;

    @Column(name = "UPDATE_TIMESTAMP")
    private LocalDateTime updateTimestamp;

    @ManyToOne
    @JoinColumn(name = "PSEUDO_TABLE_ID", nullable = false)
    private kr.co.metlife.pseudomgtsystemapi.store.entity.Table table;
}
