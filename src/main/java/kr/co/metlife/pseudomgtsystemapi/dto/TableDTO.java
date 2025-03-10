package kr.co.metlife.pseudomgtsystemapi.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class TableDTO implements Cloneable, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private String id;
    private String name;
    private String logicalName;
    private String inputUsername;
    private LocalDateTime inputTimestamp;
    private String updateUsername;
    private LocalDateTime updateTimestamp;
}