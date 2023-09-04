package com.example.testammper.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceResponse {
    private double incomes;
    private double expenses;
    private double balance;
}
