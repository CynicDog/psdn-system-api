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
@Table(name = "PSEUDO_PROJECT")
public class Project {

    @Column(name = "PSEUDO_PROJECT_ID", nullable = false)
    private UUID uuid;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_ID")
    private Long id;

    @Column(name = "PROJECT_NAME", nullable = false)
    private String name;

    @Column(name = "PROJECT_SEQUENCE", nullable = false)
    private Integer sequence;

    @Column(name = "PROJECT_EXPLANATION")
    private String explanation;

    @Column(name = "INPUT_USER_CODE")
    private String inputUserCode;

    @CreationTimestamp
    @Column(name = "INPUT_TIMESTAMP")
    private LocalDateTime inputTimestamp;

    @Column(name = "UPDATE_USER_CODE")
    private String updateUserCode;

    @UpdateTimestamp
    @Column(name = "UPDATE_TIMESTAMP")
    private LocalDateTime updateTimestamp;

    @ManyToOne
    @JoinColumn(name = "PSEUDO_USER_ID", nullable = false)
    private User user;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConfigTable> configTables = new ArrayList<>();

    public Project() {
    }

    public Project(String name, Integer sequence, String explanation, User user) {
        setUuid(UUID.randomUUID());
        this.name = name;
        this.sequence = sequence;
        this.explanation = explanation;
        setUser(user);
    }
}
