package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter @Setter
@Table(name = "PSEUDO_USER")
public class User {

    @Column(name = "PSEUDO_USER_ID", nullable = false)
    private String uuid;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "PSEUDO_USERNAME", unique = true, nullable = false)
    private String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Project> projects = new HashSet<>();

    public User() {
    }

    public User(String username) {
        setUuid(UUID.randomUUID().toString());
        this.username = username;
    }
}
