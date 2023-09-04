package com.example.testammper.model.request.links;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterLinkRequest {
    private String institution;
    private String username;
    private String password;
}
