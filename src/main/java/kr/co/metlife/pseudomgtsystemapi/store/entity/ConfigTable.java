package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Table(name = "PSEUDO_CONFIG_TABLE")
//@PrimaryKeyJoinColumn(name = "PSEUDO_TABLE_ID")
public class ConfigTable extends Table {

    @ManyToOne
    @JoinColumn(name = "PSEUDO_PROJECT_ID", nullable = false)
    private Project project;

    @OneToMany(mappedBy = "configTable", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConfigTableColumn> configColumns = new ArrayList<>();
}
