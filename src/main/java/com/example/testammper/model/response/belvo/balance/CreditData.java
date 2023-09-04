package com.example.testammper.model.response.belvo.balance;

import lombok.Data;

import java.util.Date;

@Data
public class CreditData {
    private Date collected_at;
    private int credit_limit;
    private String cutting_date;
    private double interest_rate;
    private double minimum_payment;
    private int monthly_payment;
    private String last_payment_date;
    private String next_payment_date;
    private double last_period_balance;
    private double no_interest_payment;
}
