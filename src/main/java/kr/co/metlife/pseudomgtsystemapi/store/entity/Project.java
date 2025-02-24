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
@Table(name = "PSEUDO_PROJECT")
public class Project {

    @Id @UuidGenerator
    @Column(name = "PSEUDO_PROJECT_ID", nullable = false)
    private UUID id;

    @Column(name = "PSEUDO_USER_ID", nullable = false)
    private UUID userId;

    @Column(name = "PROJECT_NAME")
    private String name;

    @Column(name = "PROJECT_SEQUENCE")
    private Integer sequence;

    @Column(name = "PROJECT_EXPLANATION")
    private String explanation;

    public Project() {
    }

    public Project(UUID userId, String name, Integer sequence, String explanation) {
        this.userId = userId;
        this.name = name;
        this.sequence = sequence;
        this.explanation = explanation;
    }
}
