package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PSEUDO_CONFIG_COLUMN_RULE")
//@PrimaryKeyJoinColumn(name = "PSEUDO_RULE_ID")
public class ConfigColumnRule extends Rule {

    @ManyToOne
    @JoinColumn(name = "PSEUDO_CONFIG_TABLE_COLUMN_ID", nullable = false)
    private ConfigTableColumn configTableColumn;

    @Column(name = "RULE_ORDER", nullable = false)
    private Integer order;

    @OneToMany(mappedBy = "configColumnRule", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<ConfigRuleParameter> configParameters;
}
