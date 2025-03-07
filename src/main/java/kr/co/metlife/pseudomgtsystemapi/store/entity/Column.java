package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.Table;
import jakarta.persistence.*;
import kr.co.metlife.pseudomgtsystemapi.store.util.StringToLocalDateTimeConverter;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * 컬럼 메타 Entity를 정의합니다.
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PSEUDO_COLUMN")
public class Column {

    @Id
    @GeneratedValue(generator = "custom-uuid")
    @GenericGenerator(name = "custom-uuid", strategy = "kr.co.metlife.pseudomgtsystemapi.store.util.CustomUUIDGenerator")
    @jakarta.persistence.Column(name = "PSEUDO_COLUMN_ID", nullable = false, length = 32)
    private String id;

    /**
     * 테이블 ID입니다.
     */
    @jakarta.persistence.Column(name = "PSEUDO_TABLE_ID", nullable = false, length = 32)
    private String tableId;

    /**
     * 컬럼명입니다.
     */
    @jakarta.persistence.Column(name = "COLUMN_NAME", nullable = false, length = 200)
    private String name;

    /**
     * 컬럼 논리명입니다.
     */
    @Nationalized
    @jakarta.persistence.Column(name = "COLUMN_LOGICAL_NAME", length = 400)
    private String logicalName;

    /**
     * 컬럼 자료형입니다.
     */
    @jakarta.persistence.Column(name = "COLUMN_DATA_TYPE", length = 20)
    private String dataType;

    /**
     * 컬럼 도메인입니다.
     */
    @jakarta.persistence.Column(name = "COLUMN_DOMAIN", length = 200)
    private String domain;

    /**
     * 컬럼 암호화 타입입니다.
     */
    @jakarta.persistence.Column(name = "COLUMN_ENCODE_TYPE", length = 200)
    private String encodeType;

    /**
     * 컬럼 암호화 등급입니다.
     */
    @jakarta.persistence.Column(name = "COLUMN_ENCODE_GRADE")
    private Integer encodeGrade;

    /**
     * 컬럼이 사용하는 코드 그룹 ID입니다.
     */
    @jakarta.persistence.Column(name = "USE_CODE_GROUP_ID", length = 50)
    private String useCodeGroupId;

    /**
     * 데이터 입력 사용자명입니다.
     */
    @jakarta.persistence.Column(name = "INPUT_USERNAME", nullable = false, length = 120)
    private String inputUsername;

    /**
     * 데이터 입력 일시입니다.
     */
    @CreationTimestamp
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @jakarta.persistence.Column(name = "INPUT_TIMESTAMP", columnDefinition = "DATETIME2(3)")
    private LocalDateTime inputTimestamp;

    /**
     * 데이터 수정 사용자명입니다.
     */
    @jakarta.persistence.Column(name = "UPDATE_USERNAME", length = 120)
    private String updateUsername;

    /**
     * 데이터 수정 일시입니다.
     */
    @UpdateTimestamp
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @jakarta.persistence.Column(name = "UPDATE_TIMESTAMP", columnDefinition = "DATETIME2(3)")
    private LocalDateTime updateTimestamp;

    public Column(String tableId, String name, String logicalName, String dataType, String inputUsername) {
        this.tableId = tableId;
        this.name = name;
        this.logicalName = logicalName;
        this.dataType = dataType;
        this.inputUsername = inputUsername;
    }
}
