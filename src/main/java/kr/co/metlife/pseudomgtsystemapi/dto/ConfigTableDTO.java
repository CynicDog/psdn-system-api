package kr.co.metlife.pseudomgtsystemapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class ConfigTableDTO {
    private String projectId;
    private String tableId;
    private Integer iteration;
    private String name;
    private String logicalName;
    private Integer sequence;
    private String inputUserId;
    private LocalDateTime inputTimestamp;
    private String updateUserId;
    private LocalDateTime updateTimestamp;
}
