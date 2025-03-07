package kr.co.metlife.pseudomgtsystemapi.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
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

    public TableDTO(String id, String name, String logicalName, String inputUsername, LocalDateTime inputTimestamp, String updateUsername, LocalDateTime updateTimestamp) {
        this.id = id;
        this.name = name;
        this.logicalName = logicalName;
        this.inputUsername = inputUsername;
        this.inputTimestamp = inputTimestamp;
        this.updateUsername = updateUsername;
        this.updateTimestamp = updateTimestamp;
    }
}

