package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PSEUDO_CONFIG_RULE_PARAMETER")
//@PrimaryKeyJoinColumn(name = "PSEUDO_PARAMETER_ID")
public class ConfigRuleParameter extends Parameter {

    @ManyToOne
    @JoinColumn(name = "PSEUDO_CONFIG_COLUMN_RULE_ID", nullable = false)
    private ConfigColumnRule configColumnRule;

    @Column(name = "CONFIG_PARAMETER_VALUE", nullable = true)
    private String configValue;
}
