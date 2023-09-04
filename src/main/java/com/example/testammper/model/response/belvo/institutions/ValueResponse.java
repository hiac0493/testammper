package com.example.testammper.model.response.belvo.institutions;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class ValueResponse {
    public String code;
    public String label;
    public String validation;
    @JsonProperty("validation_message")
    public String validationMessage;
    public String placeholder;
}
