package com.example.testammper.model.response.belvo.institutions;

import lombok.Data;

import java.util.List;

@Data
public class BelvoInstitutionsResponse {
    private int count;
    private Object next;
    private Object previous;
    private List<InstitutionsDetailResponse> results;
}
