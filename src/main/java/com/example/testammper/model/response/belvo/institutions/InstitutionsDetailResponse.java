package com.example.testammper.model.response.belvo.institutions;

import com.example.testammper.model.response.belvo.institutions.FeatureResponse;
import com.example.testammper.model.response.belvo.institutions.FormFieldResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class InstitutionsDetailResponse {
    private int id;
    private String name;
    private String type;
    private String code;
    private Object website;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("country_codes")
    private List<String> countryCodes;
    @JsonProperty("primary_color")
    private String primaryColor;
    private String logo;
    @JsonProperty("icon_logo")
    private String iconLogo;
    @JsonProperty("text_logo")
    private String textLogo;
    @JsonProperty("form_fields")
    private List<FormFieldResponse> formFields;
    private Object customization;
    private List<FeatureResponse> features;
    private String integration_type;
    private String status;
    private List<String> resources;
    @JsonProperty("openbanking_information")
    private Object openbankingInformation;
}
