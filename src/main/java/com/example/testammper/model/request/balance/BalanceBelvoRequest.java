package com.example.testammper.model.request.balance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BalanceBelvoRequest {
    private String link;
    @JsonProperty("date_from")
    private String dateForm;
    @JsonProperty("date_to")
    private String dateTo;
}
