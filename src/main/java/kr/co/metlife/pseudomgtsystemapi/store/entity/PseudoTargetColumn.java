package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "PSEUDO_TARGET_COLUMN", schema = "pseudo")
public class PseudoTargetColumn {
    @Id
    @Column(name = "PSEUDO_TARGET_COLUMN_ID", nullable = false, length = 32)
    private String pseudoTargetColumnId;

    @Column(name = "TABLE_ID", nullable = false)
    private Long tableId;

    @Column(name = "COLUMN_ID", nullable = false)
    private Long columnId;

    @Column(name = "COLUMN_NAME", nullable = false, length = 128)
    private String columnName;

    @Nationalized
    @Column(name = "COLUMN_LOGIC_MAME")
    private String columnLogicMame;

    @Column(name = "COLUMN_DATA_TYPE", nullable = false, length = 20)
    private String columnDataType;

    @Nationalized
    @Column(name = "COLUMN_DOMAIN", length = 100)
    private String columnDomain;

    @Column(name = "COLUMN_ENCODE_TYPE", length = 50)
    private String columnEncodeType;

    @Column(name = "COLUMN_ENCODE_GRADE")
    private Integer columnEncodeGrade;

    @Column(name = "USE_CODE_GROUP_ID", length = 5)
    private String useCodeGroupId;

    @Column(name = "INPUT_USER_CODE", nullable = false, length = 8)
    private String inputUserCode;

    @Column(name = "INPUT_TIMESTAMP", nullable = false)
    private Instant inputTimestamp;

    @Column(name = "UPDATE_USER_CODE", nullable = false, length = 8)
    private String updateUserCode;

    @Column(name = "UPDATE_TIMESTAMP", nullable = false)
    private Instant updateTimestamp;

}