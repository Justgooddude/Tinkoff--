package edu.java.control.commandDto;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class APIEresponse {
    public String description;
    public String code;
    public String exceptionName;
    public String exceptionMessage;
    public List<String> stackTrace;

    public APIEresponse(String description, String code, String simpleName, String message, List<String> list) {
        this.description=description;
        this.code=code;
        this.exceptionName=simpleName;
        this.exceptionMessage= message;
        this.stackTrace=list;
    }
}
