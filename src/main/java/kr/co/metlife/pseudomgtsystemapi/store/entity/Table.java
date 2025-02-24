package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@jakarta.persistence.Table(name = "PSEUDO_TABLE")
public class Table {

    @Id @UuidGenerator
    @Column(name = "PSEUDO_TABLE_ID", nullable = false)
    private UUID id;

    @Column(name = "TABLE_NAME")
    private String name;

    @Column(name = "TABLE_LOGICAL_NAME")
    private String logicalName;

    public Table() {
    }

    public Table(String name, String logicalName) {
        this.name = name;
        this.logicalName = logicalName;
    }
}
