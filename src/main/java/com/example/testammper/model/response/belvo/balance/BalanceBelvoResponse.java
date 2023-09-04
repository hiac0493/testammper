package com.example.testammper.model.response.belvo.balance;

import lombok.Data;

import java.util.List;

@Data
public class BalanceBelvoResponse {
    private int count;
    private Object next;
    private String previous;
    private List<BalanceDetailResponse> results;
}
