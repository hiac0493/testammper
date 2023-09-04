package com.example.testammper.service;

import com.example.testammper.model.request.balance.BalanceRequest;
import com.example.testammper.model.response.BalanceResponse;
import com.example.testammper.model.response.InstitutionsResponse;

import java.util.List;

public interface BelvoService {
    List<InstitutionsResponse> getInstitutions();

    BalanceResponse getBalance(BalanceRequest request);
}
