package kr.co.metlife.pseudomgtsystemapi.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ParameterDTO implements Cloneable, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private String id;
    private String attributeName;
    private String nameKorean;
    private String nameEnglish;
    private String type;
    private Object defaultValue;
    private String explanation;
    private String inputUserId;
    private LocalDateTime inputTimestamp;
    private String updateUserId;
    private LocalDateTime updateTimestamp;

    public ParameterDTO(String id, String attributeName, String nameKorean, String nameEnglish, String type, Object defaultValue, String explanation, String inputUserId, LocalDateTime inputTimestamp, String updateUserId, LocalDateTime updateTimestamp) {
        this.id = id;
        this.attributeName = attributeName;
        this.nameKorean = nameKorean;
        this.nameEnglish = nameEnglish;
        this.type = type;
        this.defaultValue = defaultValue;
        this.explanation = explanation;
        this.inputUserId = inputUserId;
        this.inputTimestamp = inputTimestamp;
        this.updateUserId = updateUserId;
        this.updateTimestamp = updateTimestamp;
    }
}
