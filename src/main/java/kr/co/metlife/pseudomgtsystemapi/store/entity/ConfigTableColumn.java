package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PSEUDO_CONFIG_TABLE_COLUMN")
//@PrimaryKeyJoinColumn(name = "PSEUDO_TABLE_COLUMN_ID")
public class ConfigTableColumn extends TableColumn {

    @ManyToOne
    @JoinColumn(name = "PSEUDO_CONFIG_TABLE_ID", nullable = false)
    private ConfigTable configTable;

    @OneToMany(mappedBy = "configTableColumn", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConfigColumnRule> rules;
}
