package kr.co.metlife.pseudomgtsystemapi.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class RuleDTO implements Cloneable, Serializable {

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
    private Integer sequence;
    private String explanation;
    private String inputUsername;
    private LocalDateTime inputTimestamp;
    private String updateUsername;
    private LocalDateTime updateTimestamp;

    public RuleDTO(String id, String attributeName, String nameKorean, String nameEnglish, Integer sequence, String explanation, String inputUsername, LocalDateTime inputTimestamp, String updateUsername, LocalDateTime updateTimestamp) {
        this.id = id;
        this.attributeName = attributeName;
        this.nameKorean = nameKorean;
        this.nameEnglish = nameEnglish;
        this.sequence = sequence;
        this.explanation = explanation;
        this.inputUsername = inputUsername;
        this.inputTimestamp = inputTimestamp;
        this.updateUsername = updateUsername;
        this.updateTimestamp = updateTimestamp;
    }
}
