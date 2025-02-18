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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PSEUDO_USER")
public class User {

    @Id @UuidGenerator
    @Column(name = "PSEUDO_USER_ID")
    private UUID uuid;

    @Column(name = "PSEUDO_USERNAME", unique = true, nullable = false)
    private String username;

    @OneToMany
    Set<Project> projects = new HashSet<>();
}
