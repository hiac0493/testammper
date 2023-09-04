package com.example.testammper.model.response.belvo.balance;

import lombok.Data;

import java.util.Date;

@Data
public class LoanData {
    private Object fees;
    private String limit_day;
    private Object loan_type;
    private Object principal;
    private String limit_date;
    private String cutting_day;
    private Date collected_at;
    private int credit_limit;
    private String cutting_date;
    private Object interest_rate;
    private Object interest_rates;
    private Object contract_number;
    private Object monthly_payment;
    private Object payment_due_day;
    private String last_payment_date;
    private String next_payment_date;
    private Object contract_start_date;
    private Object last_period_balance;
    private Object no_interest_payment;
    private Object outstanding_balance;
    private Object outstanding_principal;
    private Object number_of_installments_total;
    private Object number_of_installments_outstanding;
}
