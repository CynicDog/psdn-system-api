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
    private String inputUserId;
    private LocalDateTime inputTimestamp;
    private String updateUserId;
    private LocalDateTime updateTimestamp;

    public RuleDTO(String id, String attributeName, String nameKorean, String nameEnglish, Integer sequence, String explanation, String inputUserId, LocalDateTime inputTimestamp, String updateUserId, LocalDateTime updateTimestamp) {
        this.id = id;
        this.attributeName = attributeName;
        this.nameKorean = nameKorean;
        this.nameEnglish = nameEnglish;
        this.sequence = sequence;
        this.explanation = explanation;
        this.inputUserId = inputUserId;
        this.inputTimestamp = inputTimestamp;
        this.updateUserId = updateUserId;
        this.updateTimestamp = updateTimestamp;
    }
}
