package kr.co.metlife.pseudomgtsystemapi.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import kr.co.metlife.pseudomgtsystemapi.store.util.StringToLocalDateTimeConverter;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * 공통 코드 상세 Entity를 정의합니다.
 */
@Entity
@Getter
@Setter
@Table(name = "COMMON_CODE_DETAIL")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonCodeDetail {

    @Id
    @GeneratedValue(generator = "custom-uuid")
    @GenericGenerator(name = "custom-uuid", strategy = "kr.co.metlife.pseudomgtsystemapi.store.util.CustomUUIDGenerator")
    @Column(name = "COMMON_CODE_DETAIL_ID", nullable = false, length = 32)
    private String id;

    /**
     * 코드 그룹 ID입니다.
     */
    @Column(name = "CODE_GROUP_ID", nullable = false, length = 50)
    private String codeGroupId;

    /**
     * 코드입니다.
     */
    @Column(name = "CODE", nullable = false, length = 50)
    private String code;

    /**
     * 코드명입니다.
     */
    @Column(name = "CODE_NAME", nullable = false, length = 150)
    private String codeName;

    /**
     * 코드 순서입니다.
     */
    @Column(name = "CODE_SEQUENCE")
    private Integer codeSequence;

    /**
     * 코드 설명입니다.
     */
    @Column(name = "CODE_EXPLANATION")
    private String explanation;

    /**
     * 데이터 입력 사용자명입니다.
     */
    @Column(name = "INPUT_USERNAME", nullable = false, length = 120)
    private String inputUsername;

    /**
     * 데이터 입력 일시입니다.
     */
    @CreationTimestamp
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "INPUT_TIMESTAMP", nullable = false, columnDefinition = "DATETIME2(3)")
    private LocalDateTime inputTimestamp;

    /**
     * 데이터 수정 사용자명입니다.
     */
    @Column(name = "UPDATE_USERNAME", length = 120)
    private String updateUsername;

    /**
     * 데이터 수정 일시입니다.
     */
    @UpdateTimestamp
    @Convert(converter= StringToLocalDateTimeConverter.class)
    @Column(name = "UPDATE_TIMESTAMP", columnDefinition = "DATETIME2(3)")
    private LocalDateTime updateTimestamp;
}
