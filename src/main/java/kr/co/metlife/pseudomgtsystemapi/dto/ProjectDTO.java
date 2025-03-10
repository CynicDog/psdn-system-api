package kr.co.metlife.pseudomgtsystemapi.dto;

import kr.co.metlife.pseudomgtsystemapi.store.entity.ConfigTable;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ProjectDTO implements Cloneable, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private String id;
    private String username;
    private String name;
    private Integer sequence;
    private String status;
    private String explanation;
    private LocalDateTime createTimestamp;
    private LocalDateTime approveTimestamp;
    private LocalDateTime startTimestamp;
    private LocalDateTime finishTimestamp;
    private List<ConfigTable> configTables;
}
