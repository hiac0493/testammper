package com.example.testammper.model.response.belvo.links;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RegisterLinkResponse {
    private String id;
    private String institution;
    private String access_mode;
    private String status;
    private String refresh_rate;
    private String created_by;
    private Date last_accessed_at;
    private Object external_id;
    private Date created_at;
    private String institution_user_id;
    private String credentials_storage;
    private boolean fetch_historical;
    private List<Object> fetch_resources;
}
