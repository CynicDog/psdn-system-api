package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import kr.co.metlife.pseudomgtsystemapi.store.util.StringToLocalDateTimeConverter;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

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

    @jakarta.persistence.Column(name = "PSEUDO_TABLE_ID", nullable = false, length = 32)
    private String tableId;

    @jakarta.persistence.Column(name = "COLUMN_NAME", nullable = false, length = 200)
    private String name;

    @jakarta.persistence.Column(name = "COLUMN_LOGICAL_NAME", length = 400)
    private String logicalName;

    @jakarta.persistence.Column(name = "COLUMN_DATA_TYPE", length = 20)
    private String dataType;

    @jakarta.persistence.Column(name = "COLUMN_DOMAIN", length = 200)
    private String domain;

    @jakarta.persistence.Column(name = "COLUMN_ENCODE_TYPE", length = 200)
    private String encodeType;

    @jakarta.persistence.Column(name = "COLUMN_ENCODE_GRADE")
    private Integer encodeGrade;

    @jakarta.persistence.Column(name = "USE_CODE_GROUP_ID", length = 20)
    private String useCodeGroupId;

    @jakarta.persistence.Column(name = "INPUT_USER_ID", nullable = false, length = 120)
    private String inputUserId;

    @CreationTimestamp
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @jakarta.persistence.Column(name = "INPUT_TIMESTAMP", nullable = false, columnDefinition = "DATETIME2(3)")
    private LocalDateTime inputTimestamp;

    @jakarta.persistence.Column(name = "UPDATE_USER_ID", nullable = false, length = 120)
    private String updateUserId;

    @UpdateTimestamp
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @jakarta.persistence.Column(name = "UPDATE_TIMESTAMP", nullable = false, columnDefinition = "DATETIME2(3)")
    private LocalDateTime updateTimestamp;
}
