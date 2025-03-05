package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import kr.co.metlife.pseudomgtsystemapi.store.util.ParameterValueConverter;
import kr.co.metlife.pseudomgtsystemapi.store.util.StringToLocalDateTimeConverter;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`PSEUDO_CONFIG_PARAMETER`")
public class ConfigParameter {

    @Id
    @GeneratedValue(generator = "custom-uuid")
    @GenericGenerator(name = "custom-uuid", strategy = "kr.co.metlife.pseudomgtsystemapi.store.util.CustomUUIDGenerator")
    @Column(name = "PSEUDO_CONFIG_PARAMETER_ID", nullable = false, length = 32)
    private String id;

    @Column(name = "PSEUDO_CONFIG_TABLE_ID", nullable = false, length = 32)
    private String configTableId;

    @Column(name = "PSEUDO_CONFIG_COLUMN_ID", nullable = false, length = 32)
    private String configColumnId;

    @Column(name = "PSEUDO_CONFIG_RULE_ID", nullable = false, length = 32)
    private String configRuleId;

    @Column(name = "PSEUDO_PARAMETER_ID", nullable = false, length = 32)
    private String parameterId;

    @Column(name = "ITERATION", nullable = false)
    private Integer iteration;

    @Column(name = "PARAMETER_ATTRIBUTE_NAME", nullable = false, length = 50)
    private String attributeName;

    @Column(name = "PARAMETER_KOREAN_NAME", nullable = false, length = 50)
    private String nameKorean;

    @Column(name = "PARAMETER_ENGLISH_NAME", nullable = false, length = 32)
    private String nameEnglish;

    @Column(name = "PARAMETER_TYPE", length = 20)
    private String type;

    @Convert(converter = ParameterValueConverter.class)
    @Column(name = "PARAMETER_DEFAULT_VALUE")
    private Object defaultValue;

    @Column(name = "PARAMETER_EXPLANATION")
    private String explanation;

    @Column(name = "INPUT_USER_ID", nullable = false, length = 120)
    private String inputUserId;

    @CreationTimestamp
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "INPUT_TIMESTAMP", nullable = false, columnDefinition = "DATETIME2(3)")
    private LocalDateTime inputTimestamp;

    @Column(name = "UPDATE_USER_ID", nullable = false, length = 120)
    private String updateUserId;

    @UpdateTimestamp
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "UPDATE_TIMESTAMP", nullable = false, columnDefinition = "DATETIME2(3)")
    private LocalDateTime updateTimestamp;
}
