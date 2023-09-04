package com.example.testammper.model.response.belvo.institutions;

import lombok.Data;

import java.util.List;

@Data
public class FeatureResponse {
    private String name;
    private String type;
    private String label;
    private String validation;
    private String placeholder;
    private String validation_message;
    private String length;
    private boolean optional;
    private List<ValueResponse> values;
    private int pre_selected;
    private String value;
}
