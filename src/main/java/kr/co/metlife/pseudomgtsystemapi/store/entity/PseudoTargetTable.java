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
@Table(name = "PSEUDO_TARGET_TABLE", schema = "pseudo")
public class PseudoTargetTable {
    @Id
    @Column(name = "PSEUDO_TARGET_TABLE_ID", nullable = false, length = 32)
    private String pseudoTargetTableId;

    @Column(name = "TABLE_ID", nullable = false)
    private Long tableId;

    @Column(name = "TABLE_MAME", nullable = false, length = 128)
    private String tableMame;

    @Nationalized
    @Column(name = "TABLE_LOGIC_MAME", nullable = false)
    private String tableLogicMame;

    @Column(name = "INPUT_USER_CODE", nullable = false, length = 8)
    private String inputUserCode;

    @Column(name = "INPUT_TIMESTAMP", nullable = false)
    private Instant inputTimestamp;

    @Column(name = "UPDATE_USER_CODE", nullable = false, length = 8)
    private String updateUserCode;

    @Column(name = "UPDATE_TIMESTAMP", nullable = false)
    private Instant updateTimestamp;

}