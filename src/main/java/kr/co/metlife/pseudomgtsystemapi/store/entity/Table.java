package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
@jakarta.persistence.Table(name = "PSEUDO_TABLE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Table {

    @Column(name = "PSEUDO_TABLE_ID", nullable = false)
    private String uuid;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TABLE_ID")
    private Long id;

    @Column(name = "TABLE_NAME", nullable = false)
    private String name;

    @Column(name = "TABLE_LOGICAL_NAME", nullable = false)
    private String logicalName;

    @Column(name = "INPUT_USER_CODE")
    private String inputUserCode;

//    @CreationTimestamp
    @Column(name = "INPUT_TIMESTAMP")
    private LocalDateTime inputTimestamp;

    @Column(name = "UPDATE_USER_CODE")
    private String updateUserCode;

//    @UpdateTimestamp
    @Column(name = "UPDATE_TIMESTAMP")
    private LocalDateTime updateTimestamp;

    @OneToMany(mappedBy = "table", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<TableColumn> columns = new ArrayList<>();

    public Table() {
    }

    public Table(String name, String logicalName) {
        setUuid(UUID.randomUUID().toString());
        this.name = name;
        this.logicalName = logicalName;
    }

    public void addTableColumn(TableColumn column) {
        if (this.columns == null) {
            this.columns = new ArrayList<>();
        }
        column.setTable(this);
        this.columns.add(column);
    }

    public void addTableColumns(List<TableColumn> columns) {
        if (this.columns == null) {
            this.columns = new ArrayList<>();
        }
        columns.forEach(this::addTableColumn);
    }
}
