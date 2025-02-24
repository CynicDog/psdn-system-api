package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "PSEUDO_USER")
public class User {

    @Id @UuidGenerator
    @Column(name = "PSEUDO_USER_ID", nullable = false)
    private UUID id;

    @Column(name = "PSEUDO_USERNAME", unique = true, nullable = false)
    private String username;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }
}
