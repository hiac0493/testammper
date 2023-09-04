package com.example.testammper.model.response.belvo.balance;

import lombok.Data;

import java.util.Date;

@Data
public class BalanceDetailResponse {
    private String id;
    private Account account;
    private Date created_at;
    private String category;
    private Object subcategory;
    private Merchant merchant;
    private String type;
    private double amount;
    private String status;
    private double balance;
    private String currency;
    private String reference;
    private String value_date;
    private String description;
    private Date collected_at;
    private Object observations;
    private Date accounting_date;
    private String internal_identification;
}
