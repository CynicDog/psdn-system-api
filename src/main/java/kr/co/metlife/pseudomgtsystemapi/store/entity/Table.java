package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter @Setter
@jakarta.persistence.Table(name = "PSEUDO_TABLE")
public class Table {

    @Id @UuidGenerator
    @Column(name = "PSEUDO_TABLE_ID", nullable = false)
    private String uuid;

    @Column(name = "TABLE_NAME", nullable = false)
    private String name;

    @Column(name = "TABLE_LOGICAL_NAME", nullable = false)
    private String logicalName;
}
