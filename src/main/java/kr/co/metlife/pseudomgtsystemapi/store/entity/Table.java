package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import kr.co.metlife.pseudomgtsystemapi.store.util.StringToLocalDateTimeConverter;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Table(name = "PSEUDO_TABLE")
public class Table {

    @Id
    @GeneratedValue(generator = "custom-uuid")
    @GenericGenerator(name = "custom-uuid", strategy = "kr.co.metlife.pseudomgtsystemapi.store.util.CustomUUIDGenerator")
    @Column(name = "PSEUDO_TABLE_ID", nullable = false, length = 32)
    private String id;

    @Column(name = "TABLE_NAME", nullable = false, length = 200)
    private String name;

    @Column(name = "TABLE_LOGICAL_NAME", length = 400)
    private String logicalName;

    @Column(name = "INPUT_USER_ID", nullable = false, length = 120)
    private String inputUserId;

    @CreationTimestamp
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "INPUT_TIMESTAMP", nullable = true, columnDefinition = "DATETIME2(3)")
    private LocalDateTime inputTimestamp;

    @Column(name = "UPDATE_USER_ID", nullable = true, length = 120)
    private String updateUserId;

    @UpdateTimestamp
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "UPDATE_TIMESTAMP", nullable = true, columnDefinition = "DATETIME2(3)")
    private LocalDateTime updateTimestamp;

    public Table(String name, String logicalName, String inputUserId) {
        this.name = name;
        this.logicalName = logicalName;
        this.inputUserId = inputUserId;
    }
}
