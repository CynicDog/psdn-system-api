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
@Table(name = "COMMON_CODE_DETAIL", schema = "pseudo")
public class CommonCodeDetail {
    @Id
    @Column(name = "COMMON_CODE_DETAIL_ID", nullable = false, length = 32)
    private String commonCodeDetailId;

    @Column(name = "CODE_ID", nullable = false, length = 50)
    private String codeId;

    @Column(name = "CODE_GROUP_ID", nullable = false, length = 50)
    private String codeGroupId;

    @Nationalized
    @Column(name = "CODE_NAME", nullable = false, length = 100)
    private String codeName;

    @Column(name = "CODE_SEQUENCE", nullable = false)
    private Integer codeSequence;

    @Nationalized
    @Column(name = "EXPLANATION", length = 1000)
    private String explanation;

    @Column(name = "INPUT_USER_CODE", nullable = false, length = 8)
    private String inputUserCode;

    @Column(name = "INPUT_TIMESTAMP", nullable = false)
    private Instant inputTimestamp;

    @Column(name = "UPDATE_USER_CODE", nullable = false, length = 8)
    private String updateUserCode;

    @Column(name = "UPDATE_TIMESTAMP", nullable = false)
    private Instant updateTimestamp;

}