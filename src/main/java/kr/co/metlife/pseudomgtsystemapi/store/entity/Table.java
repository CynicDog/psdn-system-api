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
import java.util.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Table(name = "PSEUDO_TABLE")
public class Table {

    @Id @UuidGenerator
    @Column(name = "PSEUDO_TABLE_ID")
    private UUID uuid;

    @Column(name = "TABLE_ID", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "TABLE_NAME", nullable = false)
    private String name;

    @Column(name = "TABLE_LOGICAL_NAME", nullable = false)
    private String logicalName;

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

    @ManyToMany(mappedBy = "tables", fetch = FetchType.LAZY)
    private Set<Project> projects = new HashSet<>();

    @OneToMany(mappedBy = "table", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TableColumn> columns = new ArrayList<>();
}
