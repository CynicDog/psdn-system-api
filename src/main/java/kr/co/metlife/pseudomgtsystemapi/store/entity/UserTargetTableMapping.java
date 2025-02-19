package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "USER_TARGET_TABLE_MAPPING", schema = "pseudo")
public class UserTargetTableMapping {
    @Id
    @Column(name = "USER_TARGET_TABLE_MAPPING_ID", nullable = false, length = 32)
    private String userTargetTableMappingId;

    @Column(name = "USER_CODE", nullable = false, length = 8)
    private String userCode;

    @Column(name = "TABLE_ID", nullable = false)
    private Long tableId;

    @Column(name = "INPUT_USER_CODE", nullable = false, length = 8)
    private String inputUserCode;

    @Column(name = "INPUT_TIMESTAMP", nullable = false)
    private Instant inputTimestamp;

    @Column(name = "UPDATE_USER_CODE", nullable = false, length = 8)
    private String updateUserCode;

    @Column(name = "UPDATE_TIMESTAMP", nullable = false)
    private Instant updateTimestamp;

}