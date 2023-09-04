package com.example.testammper.model.response.belvo.balance;

import lombok.Data;

import java.util.Date;

@Data
public class Account {
    private String id;
    private String link;
    private Institution institution;
    private Date created_at;
    private String name;
    private String type;
    private String agency;
    private String number;
    private Balance balance;
    private String category;
    private String currency;
    private LoanData loan_data;
    private CreditData credit_data;
    private String balance_type;
    private Date collected_at;
    private String bank_product_id;
    private Date last_accessed_at;
    private String internal_identification;
    private String public_identification_name;
    private String public_identification_value;
}
