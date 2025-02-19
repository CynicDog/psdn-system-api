package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PSEUDO_PROJECT")
public class Project {

    @Id @UuidGenerator
    @Column(name = "PSEUDO_PROJECT_ID")
    private UUID uuid;

    @Column(name = "PROJECT_ID", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "PROJECT_NAME", nullable = false)
    private String name;

    @Column(name = "PROJECT_SEQUENCE", nullable = false)
    private Integer sequence;

    @Column(name = "PROJECT_EXPLANATION")
    private String explanation;

    @CreationTimestamp
    @Column(name = "CREATE_TIMESTAMP")
    private LocalDateTime createTimestamp;

    @UpdateTimestamp
    @Column(name = "UPDATE_TIMESTAMP")
    private LocalDateTime updateTimestamp;

    @ManyToOne
    @JoinColumn(name = "PSEUDO_USER_ID", nullable = false)
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "PSEUDO_PROJECT_TABLE",
            joinColumns = @JoinColumn(name = "PSEUDO_PROJECT_ID"),
            inverseJoinColumns = @JoinColumn(name = "PSEUDO_TABLE_ID")
    )
    private List<kr.co.metlife.pseudomgtsystemapi.store.entity.Table> tables = new ArrayList<>();
}
